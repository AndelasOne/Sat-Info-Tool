/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 12.06.2021, Samstag
 *
 * Copyright (c) 2021 DHBW Stuttgart
 **/

package dhbw.swe;

public interface IOutput {
    /**
     * Function accepts data in a Tree like shape and outputs it to the user. Ex. GUI or JSON file
     * @param input data to display
     */
    void output(AbstractNode<String> input);
}
