package outputs;

import dhbw.swe.ArrayNode;
import dhbw.swe.Leaf;
import dhbw.swe.StructNode;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JSON_OutputTest {
    private final JSON_Output output = new JSON_Output();
    private final StructNode<String> structNode = new StructNode<>();
    private final JSONObject object = new JSONObject();

    @BeforeEach
    void setUp() {
        structNode.addPair("leaf1", new Leaf<>("10"));
        object.put("leaf1", "10");
        structNode.addPair("leaf2", new Leaf<>("20"));
        object.put("leaf2", "20");
        ArrayNode<String> arrayNode = new ArrayNode<>();
        JSONArray jArrayNode = new JSONArray();
        arrayNode.addElement(new Leaf<>("30"));
        jArrayNode.add("30");
        arrayNode.addElement(new Leaf<>("40"));
        jArrayNode.add("40");
        StructNode<String> structInArray = new StructNode<>();
        JSONObject jStructInArray = new JSONObject();
        structInArray.addPair("leaf1", new Leaf<>("50"));
        jStructInArray.put("leaf1", "50");
        arrayNode.addElement(structInArray);
        jArrayNode.add(jStructInArray);
        ArrayNode<String> arrayInArray = new ArrayNode<>();
        JSONArray jArrayInArray = new JSONArray();
        arrayInArray.addElement(new Leaf<>("60"));
        jArrayInArray.add("60");
        arrayNode.addElement(arrayInArray);
        jArrayNode.add(jArrayInArray);
        structNode.addPair("array1", arrayNode);
        object.put("array1", jArrayNode);
        StructNode<String> structInStruct = new StructNode<>();
        JSONObject jStructInStruct = new JSONObject();
        structInStruct.addPair("leaf1", new Leaf<>("70"));
        jStructInStruct.put("leaf1", "70");
        structNode.addPair("struct1", structInStruct);
        object.put("struct1", jStructInStruct);
    }

    @Test
    void output() throws ParseException, IOException {
        output.output(structNode);
        JSONParser parser = new JSONParser();
        File file = new File("result/result.json");
        FileReader reader = new FileReader(file);
        JSONObject obj = (JSONObject) parser.parse(reader);
        assertEquals(object.toJSONString(), obj.toJSONString());
    }
}