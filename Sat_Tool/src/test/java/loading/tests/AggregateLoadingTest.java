package loading.tests;
import dhbw.swe.ClassLoader;
import dhbw.swe.ConfigData;
import dhbw.swe.IOutput;
import dhbw.swe.IPlugin;
import org.junit.Assert;
import org.junit.Test;
import outputs.GUIOutput;
import outputs.JSON_Output;
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
    private final String germanChannel_UI_Config_PATH = "src/test/resources/germanChannel_UI_Config.json";
    private final String programCounter_JSON_Config_PATH = "src/test/resources/programCounter_JSON_Config.json";

    // init loaders
    ClassLoader<IPlugin> pluginLoader = new ClassLoader<>();
    ClassLoader<IOutput> outputLoader = new ClassLoader<>();

    /**
     * Test if reflection creates german channel plugin object that was defined in the config file
     * @throws MalformedURLException
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @Test
    public void loadGermanChannelsPlugin() throws MalformedURLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // import config data
        ConfigData config = ConfigData.importConfig(germanChannel_UI_Config_PATH);

        IPlugin plugin = pluginLoader.loadClass(
                config.getPlugin().getPath(), config.getPlugin().getClassName(),
                IPlugin.class);

        // make sure that plugin is instance of GermanChannels -> see germanChannels_UI_Config file
        Assert.assertTrue(plugin instanceof GermanChannels);
    }

    @Test
    public void loadProgramCounterPlugin() throws MalformedURLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ConfigData config = ConfigData.importConfig(programCounter_JSON_Config_PATH);
        IPlugin plugin = pluginLoader.loadClass(
                config.getPlugin().getPath(), config.getPlugin().getClassName(),
                IPlugin.class);
        Assert.assertTrue(plugin instanceof ProgramCounter);
    }

    @Test
    public void loadGuiOutput() throws MalformedURLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ConfigData config = ConfigData.importConfig(germanChannel_UI_Config_PATH);

        IOutput output = outputLoader.loadClass(
                config.getPlugin().getPath(), config.getOutput().getClassName(),
                IOutput.class);

        Assert.assertTrue(output instanceof GUIOutput);
    }

    @Test
    public void loadJsonOutput() throws MalformedURLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ConfigData config = ConfigData.importConfig(programCounter_JSON_Config_PATH);

        IOutput output = outputLoader.loadClass(
                config.getPlugin().getPath(), config.getOutput().getClassName(),
                IOutput.class);

        Assert.assertTrue(output instanceof JSON_Output);
    }
}
