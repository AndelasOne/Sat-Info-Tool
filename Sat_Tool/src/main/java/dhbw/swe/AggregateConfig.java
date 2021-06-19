/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 12.06.2021, Samstag
 * Copyright (c) 2021 DHBW Stuttgart
 **/
package dhbw.swe;


public class AggregateConfig {
    final String path;
    final String className;

    /**
     *
     * @param path path to the jar file in which the Aggregate is included
     * @param className the class name or class path where the class can be found. E.g. plugins.GermanChannels
     */
    public AggregateConfig(String path, String className) {
        this.path = path;
        this.className = className;
    }

    public String getPath() {
        return path;
    }

    public String getClassName() {
        return className;
    }
}
