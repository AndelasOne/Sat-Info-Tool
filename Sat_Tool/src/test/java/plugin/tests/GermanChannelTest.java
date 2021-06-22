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
import plugins.GermanChannels;
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
public class GermanChannelTest {
    private final JSON_Output output = new JSON_Output();

    /**
     * Manual construct a Satellite Array List corresponding to the structure given in the json test file
     * @return ArrayList of Satellites
     */
    private AbstractNode<String> createSatelliteNode(){
        final StructNode<String> structNode = new StructNode<>();
        ArrayNode<String> satellitesComposite = new ArrayNode<>();
        structNode.addPair("Satellites with german channels", satellitesComposite);

        StructNode<String> sat0 = new StructNode<>();
        satellitesComposite.addElement(sat0);


        // build up satellite elements
        Leaf<String> sym = new Leaf<>("30000");
        Leaf<String> satName = new Leaf<>("Testsatellite-1");
        Leaf<String> orbital = new Leaf<>("1.9° E");
        Leaf<String> freq = new Leaf<>("12000");
        Leaf<String> pol = new Leaf<>("H");
        ArrayNode<String> channels = new ArrayNode<>();

        StructNode<String> channel0 = new StructNode<>();
        StructNode<String> channel1 = new StructNode<>();

        // add satellite Elements
        sat0.addPair("sym", sym);
        sat0.addPair("pol",pol);
        sat0.addPair("sat",satName);
        sat0.addPair("orbital", orbital);
        sat0.addPair("freq", freq);
        sat0.addPair("german channels", channels);


        // add channels
        channels.addElement(channel0);
        channels.addElement(channel1);


        // build up german channel0 and channel4 elements
        Leaf<String> res = new Leaf<>("HD");
        Leaf<String> name1 = new Leaf<>("Testchannel1");
        Leaf<String> name2 = new Leaf<>("Testchannel4");
        Leaf<String> v_pid = new Leaf<>("2030");
        Leaf<String> enc = new Leaf<>("Bulcrypt");
        Leaf<String> pckg = new Leaf<>(" ");
        Leaf<String> type = new Leaf<>("TV");
        Leaf<String> compression = new Leaf<>("MPEG-4");
        Leaf<String> a_pid = new Leaf<>("2001 ger");
        Leaf<String> url1 = new Leaf<>("http://test1.tv/");
        Leaf<String> url2 = new Leaf<>("http://test4.tv/");
        Leaf<String> sid = new Leaf<>("100");

        // add channel0 elements
        channel0.addPair("res", res);
        channel0.addPair("name", name1);
        channel0.addPair("v_pid", v_pid);
        channel0.addPair("enc", enc);
        channel0.addPair("pckg",pckg);
        channel0.addPair("type", type);
        channel0.addPair("compression",compression);
        channel0.addPair("a_pid",a_pid);
        channel0.addPair("url", url1);
        channel0.addPair("sid", sid);

        // add channel4 elements
        channel1.addPair("res", res);
        channel1.addPair("name", name2);
        channel1.addPair("v_pid", v_pid);
        channel1.addPair("enc", enc);
        channel1.addPair("pckg",pckg);
        channel1.addPair("type", type);
        channel1.addPair("compression",compression);
        channel1.addPair("a_pid",a_pid);
        channel1.addPair("url", url2);
        channel1.addPair("sid", sid);

        return structNode;
    }

    /**
     * Reads the given config file and creates a tree of filtered by german satellites
     * @return ArrayList of Satellites
     */
    private AbstractNode<String> generateSatelliteNode() throws IllegalAccessException {
        String TEST_FILEPATH = "src/test/resources/germanChannelSatellite.json";
        ArrayList<Satellite> satelliteArrayList = ReadJSON.createSatelliteArray(TEST_FILEPATH);
        GermanChannels plugin = new GermanChannels();
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
     * Tests if filter of german channels plugin creates a correct tree
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
