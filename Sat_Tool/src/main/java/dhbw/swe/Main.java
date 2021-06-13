package dhbw.swe;

import outputs.GUIOutput;

/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 12.06.2021, Samstag
 * <p>
 * Copyright (c) 2021 DHBW Stuttgart
 **/
public class Main {
    private final String CONFIG_PATH = "";

    public static void main(String[] args) {


        ClassLoader<IPlugin> pluginLoader = new ClassLoader<>();
        ClassLoader<IOutput> outputLoader = new ClassLoader<>();

//        Class<Object>  plugin = pluginLoader.loadClass();
//        Class<Object>  output = pluginLoader.loadClass();
        GUIOutput gui = GUIOutput.getInstance();
        Composite<String> test = new Composite<>("Test");
        gui.output(test);
    }
}
