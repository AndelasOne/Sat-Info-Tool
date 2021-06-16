package aggregateLoader;

import dhbw.swe.ClassLoader;
import dhbw.swe.ConfigData;
import dhbw.swe.IPlugin;
import dhbw.swe.Main;
import org.junit.Assert;
import org.junit.Test;
import plugins.GermanChannels;
import plugins.ProgramCounter;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;

/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 16.06.2021, Mittwoch
 * Copyright (c) 2021 DHBW Stuttgart
 **/

public class AggregateLoadingTest {
    private final String TEST1_CONFIG_PATH = "src/main/resources/test1config.json";
    // init loaders
    ClassLoader<IPlugin> pluginLoader = new ClassLoader<>();

    // import config data
    ConfigData config = ConfigData.importConfig(TEST1_CONFIG_PATH);


    @Test
    public void testLoadingAggregate() throws MalformedURLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        IPlugin plugin = pluginLoader.loadClass(
                config.getPlugin().getPath(), config.getPlugin().getClassName(),
                IPlugin.class);

        Assert.assertTrue(plugin instanceof GermanChannels);
    }
}
