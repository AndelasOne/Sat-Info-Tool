package dhbw.swe;

import readJSON.ReadJSON;
import readJSON.Satellite;
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
    final AggregateConfig plugins;
    final AggregateConfig output;
    final String dataPath;


    public ConfigData(AggregateConfig plugins, AggregateConfig output, String dataPath) {
        this.plugins = plugins;
        this.output = output;
        this.dataPath = dataPath;
    }

    /**
     * parse json and create Config Object
     * @param configPath path to config file
     * @return data of config file
     */
    public static ConfigData importConfig(String configPath) {
        return ReadJSON.readConfigData(configPath);
    }

    /**
     * parse sat data and create List of Satellite Objects
     * @return satellite data
     */
    public ArrayList<Satellite> importSatData() {
        return createSatelliteArray(dataPath);
    }


}
