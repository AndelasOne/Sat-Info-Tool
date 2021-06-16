package dhbw.swe;

import outputs.GUIOutput;

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

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {


        ClassLoader<IPlugin> pluginLoader = new ClassLoader<>();
        ClassLoader<IOutput> outputLoader = new ClassLoader<>();
        ConfigData config = ConfigData.importConfig(CONFIG_PATH);
        IPlugin plugin = pluginLoader.loadClass(
                config.plugins.path, config.plugins.className,
                IPlugin.class);
        IOutput  output = outputLoader.loadClass(config.output.path, config.output.className, IOutput.class);
        ArrayList<Satellite> data = config.importSatData();
        AbstractNode<String> tree = createSatComposite(data);
        AbstractNode<String> result = plugin.filter(tree);
        output.output(result);
    }

    private static AbstractNode<String> createSatComposite(ArrayList<Satellite> list){
        return null;
    }
}
