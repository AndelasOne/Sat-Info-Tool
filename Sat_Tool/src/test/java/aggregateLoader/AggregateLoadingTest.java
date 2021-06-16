package aggregateLoader;

import dhbw.swe.ClassLoader;
import dhbw.swe.ConfigData;
import dhbw.swe.IPlugin;
import dhbw.swe.Main;
import org.junit.Test;

/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 16.06.2021, Mittwoch
 * Copyright (c) 2021 DHBW Stuttgart
 **/

public class AggregateLoadingTest {

    // init loaders
    ClassLoader<IPlugin> pluginLoader = new ClassLoader<>();

    // import config data
    ConfigData config = ConfigData.importConfig(Main.getConfigPath());

    @Test
    public void testLoadingAggregate() {

    }
}
