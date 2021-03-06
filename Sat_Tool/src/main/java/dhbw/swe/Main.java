package dhbw.swe;

import org.json.simple.parser.ParseException;
import readJSON.Satellite;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.ArrayList;

/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 12.06.2021, Samstag
 * <p>
 * Copyright (c) 2021 DHBW Stuttgart
 **/
public class Main {
    private static final String CONFIG_PATH = "src/main/resources/config.json";

    /**
     * Used patterns:
     * - Reflection to create different aggregates for filtering and to output sat data
     *
     * @param args opt. arguments
     * @throws MalformedURLException
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        // init loaders
        ClassLoader<IPlugin> pluginLoader = new ClassLoader<>();
        ClassLoader<IOutput> outputLoader = new ClassLoader<>();

        // import config data
        try {
            String path;
            if (args.length > 0) {
                path = args[0];
            } else {
                path = CONFIG_PATH;
            }
            ConfigData config = ConfigData.importConfig(path);

            // create plugin depending on config file -> Reflection pattern used
            IPlugin plugin = pluginLoader.loadClass(
                    config.plugin.path, config.plugin.className,
                    IPlugin.class);
            // create output depending on config file -> Reflection pattern used
            IOutput output = outputLoader.loadClass(config.output.path, config.output.className, IOutput.class);

            // create arraylist of satellites
            ArrayList<Satellite> data = config.importSatData();

            // convert satellite into tree -> Composite pattern and
            // filter tree with plugin aggregate
            AbstractNode<String> result = plugin.filter(data);

            // output tree with output aggregate
            output.output(result);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
