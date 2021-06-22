package plugin.tests;
import dhbw.swe.AbstractNode;
import dhbw.swe.ArrayNode;
import dhbw.swe.Leaf;
import dhbw.swe.StructNode;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import outputs.JSON_Output;
import plugins.ProgramCounter;
import readJSON.ReadJSON;
import readJSON.Satellite;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 20.06.2021, Sonntag
 * Copyright (c) 2021 DHBW Stuttgart
 **/
public class ProgramCounterTest {
    private final JSON_Output output = new JSON_Output();

    /**
     * Manual construct a Satellite Array List corresponding to the structure given in the json test file
     * @return ArrayList of Satellites
     */
    private AbstractNode<String> createSatelliteNode(){
        final StructNode<String> structNode = new StructNode<>();
        ArrayNode<String> satelliteComposite = new ArrayNode<>();
        structNode.addPair("Results: Program Counter", satelliteComposite);

        StructNode<String> sat1 = new StructNode<>();
        StructNode<String> sat2 = new StructNode<>();
        satelliteComposite.addElement(sat1);
        satelliteComposite.addElement(sat2);

        ArrayNode<String> transponderComposite1 = new ArrayNode<>();
        ArrayNode<String> transponderComposite2 = new ArrayNode<>();
        sat1.addPair("Testsatellite-1", transponderComposite1);
        sat2.addPair("Testsatellite-2", transponderComposite2);

        StructNode<String> transponder1 = new StructNode<>();
        StructNode<String> transponder2 = new StructNode<>();
        transponderComposite1.addElement(transponder1);
        transponderComposite2.addElement(transponder2);


        ArrayNode<String> programs1 = new ArrayNode<>();
        ArrayNode<String> programs2 = new ArrayNode<>();


        transponder1.addPair("freq 12000", programs1);
        transponder2.addPair("freq 12000", programs2);

        StructNode<String> program1 = new StructNode<>();
        StructNode<String> program2 = new StructNode<>();
        StructNode<String> program3 = new StructNode<>();

        programs1.addElement(program1);
        programs1.addElement(program2);
        programs2.addElement(program3);

        Leaf<String> one = new Leaf<String>("1");
        program1.addPair("TV", one);
        program2.addPair("R", one);
        program3.addPair("TV", one);
        return structNode;
    }

    /**
     * Reads the given config file and creates a tree of filtered by german satellites
     * @return ArrayList of Satellites
     */
    private AbstractNode<String> generateSatelliteNode() throws IllegalAccessException {
        String TEST_FILEPATH = "src/test/resources/testSatellites.json";
        ArrayList<Satellite> satelliteArrayList = ReadJSON.createSatelliteArray(TEST_FILEPATH);
        ProgramCounter plugin = new ProgramCounter();
        assert satelliteArrayList != null;
        return plugin.filter(satelliteArrayList);
    }

    /**
     * Creats a JSON Object out of a AbstractNode
     * @param node AbstractNode, which is the root of a given composite tree
     * @return JSONObject
     * @throws IOException
     * @throws ParseException
     */
    private JSONObject generateJSONOutput(AbstractNode<String> node) throws IOException, ParseException {
        output.output(node);
        JSONParser parser = new JSONParser();
        File file = new File("result/result.json");
        FileReader reader = new FileReader(file);
        return  (JSONObject) parser.parse(reader);
    }

    /**
     * Tests if filter of program counter plugin creates a correct tree
     * @throws IllegalAccessException
     * @throws IOException
     * @throws ParseException
     */
    @Test
    public void output() throws IllegalAccessException, IOException, ParseException {
        // 1. Create Satellite ArrayList by hand
        AbstractNode<String> createdSatelliteNode = createSatelliteNode();

        // 2. Read corresponding JSON File that describes same logic
        AbstractNode<String> readSatelliteNode = generateSatelliteNode();

        // 4. Compare result by creating two JSON Objects out of trees
        JSONObject jCreatedSatellites = generateJSONOutput(readSatelliteNode);
        JSONObject jReadSatellites = generateJSONOutput(createdSatelliteNode);

        assertEquals(jReadSatellites, jCreatedSatellites);
    }
}
