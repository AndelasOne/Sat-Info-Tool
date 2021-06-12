package dhbw.swe;

/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 12.06.2021, Samstag
 * Copyright (c) 2021 DHBW Stuttgart
 **/
public class AggregateConfig {
    private final String path;
    private final String className;

    public AggregateConfig(String path, String className) {
        this.path = path;
        this.className = className;
    }
}
