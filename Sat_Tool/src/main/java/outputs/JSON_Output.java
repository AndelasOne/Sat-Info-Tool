/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 12.06.2021, Samstag
 * <p>
 * Copyright (c) 2021 DHBW Stuttgart
 **/

package outputs;

import dhbw.swe.AbstractNode;
import dhbw.swe.IOutput;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class JSON_Output implements IOutput {
    /**
     * Generate a json file
     * @param input (filtered) input data
     */
    @Override
    public void output(AbstractNode<String> input) {
        try {
            File file = new File("result/result.json");
            file.getParentFile().mkdirs();
            FileWriter writer = new FileWriter(file);
            if(input.isArray()){
                System.out.println("Creating Array");
                JSONArray jsonArray = buildJsonArray(input);
                System.out.println("Write to file");
                jsonArray.writeJSONString(writer);
            }else {
                System.out.println("Creating Object");
                JSONObject jsonObject = buildJsonObject(input);
                System.out.println("Write to file");
                jsonObject.writeJSONString(writer);
            }
            writer.close();
            System.out.println("Finished");
        } catch (IOException e) {
            System.out.println("Could not write to file");
        }
    }

    /**
     * recursively build a JSON Object from input node
     * @param input a node Tree representing the data
     * @return JSON Object holding the data
     */
    private JSONObject buildJsonObject(AbstractNode<String> input) {
        if (input.isLeaf()) {
            JSONObject json = new JSONObject();
            json.put("result", input.getValue());
            return json;
        } else if (input.isStruct()) {
            JSONObject json = new JSONObject();
            for (Map.Entry<String, AbstractNode<String>> entry : input.getStructPairs().entrySet()) {
                AbstractNode<String> value = entry.getValue();
                if (value.isLeaf()) {
                    json.put(entry.getKey(), value.getValue());
                } else if(value.isStruct()) {
                    json.put(entry.getKey(), buildJsonObject(value));
                }else {
                    json.put(entry.getKey(), buildJsonArray(value));
                }
            }
            return json;
        } else if (input.isArray()) {
            JSONObject json = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            json.put("result", jsonArray);
            for (AbstractNode<String> dataItem : input.getArrayElements()) {
                if (dataItem.isLeaf()) {
                    jsonArray.add(dataItem.getValue());
                } else if(dataItem.isStruct()){
                    jsonArray.add(buildJsonObject(dataItem));
                }else {
                    jsonArray.add(buildJsonArray(dataItem));
                }
            }
            return json;
        } else {
            return new JSONObject();
        }
    }

    /**
     * recursively build an JSON array
     * @param input a node tree representing the data
     * @return a JSON array holding the data
     */
    private JSONArray buildJsonArray(AbstractNode<String> input){
        if (input.isLeaf()) {
            JSONArray json = new JSONArray();
            json.add(input.getValue());
            return json;
        } else if (input.isStruct()) {
            JSONArray jsonArray = new JSONArray();
            JSONObject json = new JSONObject();
            for (Map.Entry<String, AbstractNode<String>> entry : input.getStructPairs().entrySet()) {
                AbstractNode<String> value = entry.getValue();
                if (value.isLeaf()) {
                    json.put(entry.getKey(), value.getValue());
                } else if(value.isStruct()) {
                    json.put(entry.getKey(), buildJsonObject(value));
                }else {
                    json.put(entry.getKey(), buildJsonArray(value));
                }
            }
            jsonArray.add(json);
            return jsonArray;
        } else if (input.isArray()) {
            JSONArray jsonArray = new JSONArray();
            for (AbstractNode<String> dataItem : input.getArrayElements()) {
                if (dataItem.isLeaf()) {
                    jsonArray.add(dataItem.getValue());
                } else if(dataItem.isStruct()){
                    jsonArray.add(buildJsonObject(dataItem));
                }else {
                    jsonArray.add(buildJsonArray(dataItem));
                }
            }
            return jsonArray;
        } else {
            return new JSONArray();
        }
    }
}
