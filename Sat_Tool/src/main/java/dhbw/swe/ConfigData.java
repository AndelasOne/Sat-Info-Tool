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
    final AggregateConfig plugins;
    final AggregateConfig output;
    final String dataPath;

    public ConfigData(AggregateConfig plugins, AggregateConfig output, String dataPath) {
        this.plugins = plugins;
        this.output = output;
        this.dataPath = dataPath;
    }

    public static ConfigData importConfig(String configPath) {
        // parse json and create Config Object
        AggregateConfig plugins = new AggregateConfig("out/artifacts/Sat_Tool_jar/Sat_Tool.jar", "plugins.GermanChannels");
        AggregateConfig output = new AggregateConfig("out/artifacts/Sat_Tool_jar/Sat_Tool.jar", "outputs.GUIOutput");
        return new ConfigData(plugins, output, "test");
    }

    public ArrayList<Satellite> importSatData() {
        // parse sat data and create List of Satellite Objects

        return null;
    }


}
