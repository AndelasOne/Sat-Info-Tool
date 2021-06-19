/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 12.06.2021, Samstag
 *
 * Copyright (c) 2021 DHBW Stuttgart
 **/
package dhbw.swe;

import readJSON.Satellite;

import java.util.ArrayList;

public interface IPlugin {
    /**
     * Filters or analyzes a list of satellites.
     * @param input a list of satellites
     * @return a Tree like structure which represents the data to display to the user
     * @throws IllegalAccessException
     */
    AbstractNode<String> filter(ArrayList<Satellite> input) throws IllegalAccessException;
}
