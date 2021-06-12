package dhbw.swe;

import java.util.ArrayList;

/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 12.06.2021, Samstag
 * <p>
 * Copyright (c) 2021 DHBW Stuttgart
 **/

public class ConfigData {
    private final AggregateConfig plugins;
    private final AggregateConfig output;
    private final String dataPath;

    public ConfigData(AggregateConfig plugins, AggregateConfig output, String dataPath) {
        this.plugins = plugins;
        this.output = output;
        this.dataPath = dataPath;
    }

    public static ConfigData importConfig(String configPath) {
        // parse json and create Config Object

        return null;
    }

    public ArrayList<Satellite> importSatData(String dataPath) {
        // parse sat data and create List of Satellite Objects

        return null;
    }


}
