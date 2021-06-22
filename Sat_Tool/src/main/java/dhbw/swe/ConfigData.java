package dhbw.swe;

import org.json.simple.parser.ParseException;
import readJSON.ReadJSON;
import readJSON.Satellite;

import java.io.IOException;
import java.util.ArrayList;
import static readJSON.ReadJSON.createSatelliteArray;

/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 12.06.2021, Samstag
 * <p>
 * Copyright (c) 2021 DHBW Stuttgart
 **/

public class ConfigData {

    final AggregateConfig plugin;
    final AggregateConfig output;
    final String dataPath;

    /**
     *
     * @param plugins Configuration for the plugin to use
     * @param output Configuariotn for the output to use
     * @param dataPath path to a json file with satellites
     */
    public ConfigData(AggregateConfig plugins, AggregateConfig output, String dataPath) {
        this.plugin = plugins;
        this.output = output;
        this.dataPath = dataPath;
    }

    /**
     * parse json and create Config Object
     * @param configPath path to config file
     * @return data of config file
     */
    public static ConfigData importConfig(String configPath) throws IOException, ParseException {
        return ReadJSON.readConfigData(configPath);
    }

    /**
     * parse sat data and create List of Satellite Objects
     * @return satellite data
     */
    public ArrayList<Satellite> importSatData() {
        return createSatelliteArray(dataPath);
    }

    /**
     * get plugin
     * @return plugin
     */
    public AggregateConfig getPlugin() {
        return plugin;
    }

    /**
     * get output
     * @return output
     */
    public AggregateConfig getOutput() {
        return output;
    }

    public String getDataPath() {
        return dataPath;
    }

}
