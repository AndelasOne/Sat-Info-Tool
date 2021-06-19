/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 12.06.2021, Samstag
 *
 * Copyright (c) 2021 DHBW Stuttgart
 **/
package outputs;

import dhbw.swe.AbstractNode;
import dhbw.swe.IOutput;
import javafx.application.Application;


public class GUIOutput implements IOutput {
    private boolean running = false;

    /**
     * App should only run once
     * @param input Filtered data as composite
     */
    @Override
    public void output(AbstractNode<String> input) {
        if (!running) {
            App.setData(input);
            Application.launch(App.class);
            running = true;
        }
    }
}
