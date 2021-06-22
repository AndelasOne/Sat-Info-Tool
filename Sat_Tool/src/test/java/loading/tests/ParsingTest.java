package loading.tests;

import dhbw.swe.AbstractNode;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import outputs.JSON_Output;
import plugins.GermanChannels;
import readJSON.Channel;
import readJSON.ReadJSON;
import readJSON.Satellite;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 20.06.2021, Sonntag
 * Copyright (c) 2021 DHBW Stuttgart
 **/
public class ParsingTest {
    private final JSON_Output output = new JSON_Output();
    /**
     * Manual construct a Satellite Array List corresponding to the structure given in the json test file
     * @return ArrayList of Satellites
     */
    private ArrayList<Satellite> createSatelliteArrayList(){
        Channel channel1 = new Channel("100","TV","Testchannel1", "2030", "2001 ger", "MPEG-4", "http://test1.tv/", "Bulcrypt", " ", "HD" );
        Channel channel2 = new Channel("101","R","Testchannel2", "2030", "2002 ger", "MPEG-4", "http://test2.tv/", "Bulcrypt", " ", "HD" );
        Channel channel3 = new Channel("100","R","Testchannel3", "2030", "2001 eng", "MPEG-4", "http://test3.tv/", "Bulcrypt", " ", "HD" );
        Channel channel4 = new Channel("100","R","Testchannel4", "2030", "2001 eng", "MPEG-4", "http://test4.tv/", "Bulcrypt", " ", "HD" );
        Channel channel5 = new Channel("100","R","Testchannel5", "2030", "2001 ger", "MPEG-4", "http://test5.tv/", "Bulcrypt", " ", "HD" );

        ArrayList<Channel> list1 = new ArrayList<Channel> (Arrays.asList(channel1, channel2));
        ArrayList<Channel> list2 = new ArrayList<Channel> (Arrays.asList(channel3, channel4));
        ArrayList<Channel> list3 = new ArrayList<Channel> (Collections.singletonList(channel5));

        Satellite satellite1 = new Satellite("H", "Testsatellite-1", "1.9° E","30000", "12000", list1);
        Satellite satellite2 = new Satellite("H", "Testsatellite-1", "1.0° N","20000", "13000", list2);
        Satellite satellite3 = new Satellite("H", "Testsatellite-2", "1.0° N","20000", "13000", list3);

        return new ArrayList<Satellite>(Arrays.asList(satellite1, satellite2, satellite3));
    }

    /**
     * Reads the given config file and creates an ArrayList of Satellites
     * @return ArrayList of Satellites
     */
    private ArrayList<Satellite> readSatelliteArrayList(){
        String TEST_FILEPATH = "src/test/resources/parseSatellites.json";
        return ReadJSON.createSatelliteArray(TEST_FILEPATH);
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
     * Tests if the given structure in a config file gets parsed correctly
     * @throws IllegalAccessException
     * @throws IOException
     * @throws ParseException
     */
    @Test
    public void output() throws IllegalAccessException, IOException, ParseException {
        // 1. Create Satellite ArrayList by hand
        ArrayList<Satellite> createdSatelliteList = createSatelliteArrayList();

        // 2. Read corresponding JSON File that describes same logic
        ArrayList<Satellite> readSatelliteList = readSatelliteArrayList();

        // 3. Use Filter and Create Tree for variant 1. and 2.
        GermanChannels plugin = new GermanChannels();

        AbstractNode<String> treeCreatedSatellites = plugin.filter(createdSatelliteList);
        AbstractNode<String> treeReadSatellites = plugin.filter(readSatelliteList);

        // 4. Compare result by creating two JSON Objects out of trees
        JSONObject jCreatedSatellites = generateJSONOutput(treeCreatedSatellites);
        JSONObject jReadSatellites = generateJSONOutput(treeReadSatellites);

        assertEquals(jCreatedSatellites, jReadSatellites);
    }
}
