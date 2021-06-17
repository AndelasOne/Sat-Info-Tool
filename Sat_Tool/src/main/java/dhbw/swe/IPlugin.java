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
    AbstractNode<String> filter(ArrayList<Satellite> input) throws IllegalAccessException;
}
