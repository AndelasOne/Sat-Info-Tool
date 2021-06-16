/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 12.06.2021, Samstag
 *
 * Copyright (c) 2021 DHBW Stuttgart
 **/

package plugins;


import dhbw.swe.AbstractNode;
import dhbw.swe.IPlugin;

public class GermanChannels implements IPlugin {
    @Override
    public AbstractNode<String> filter(AbstractNode<String> input) {
        return input;
    }
}
