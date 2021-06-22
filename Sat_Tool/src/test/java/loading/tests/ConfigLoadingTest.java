package loading.tests;

import dhbw.swe.ConfigData;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;
import plugins.GermanChannels;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 20.06.2021, Sonntag
 * Copyright (c) 2021 DHBW Stuttgart
 **/
public class ConfigLoadingTest {
    private static final String TEST_CONFIG_PATH = "src/test/resources/testConfig.json";

    // import config data
    ConfigData config = ConfigData.importConfig(TEST_CONFIG_PATH);

    public ConfigLoadingTest() throws IOException, ParseException {
    }

    /**
     * Checks if path of loaded config file exists
     */
    @Test
    public void checkPathExist()  {
        // check for each path-attribute if files exist
        String plugin = config.getPlugin().getPath();
        String output = config.getOutput().getPath();
        String data  = config.getDataPath();

        ArrayList<Path> paths = convertToPathArray(TEST_CONFIG_PATH, plugin, output, data);

        for(Path path: paths){
            Assert.assertTrue(Files.exists(path));
        }
    }

    private ArrayList<Path> convertToPathArray(String... attributes){
        ArrayList<Path> paths = new ArrayList<Path>();
        for (String attr: attributes){
            Path attrPath = Paths.get(attr);
            paths.add(attrPath);
        }
        return paths;
    }


}
