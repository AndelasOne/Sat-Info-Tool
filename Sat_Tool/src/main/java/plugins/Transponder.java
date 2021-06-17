package plugins;

import java.util.ArrayList;

/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 17.06.2021, Donnerstag
 * Copyright (c) 2021 DHBW Stuttgart
 **/
public class Transponder {


    private final String frequency;
    private ArrayList<Program> programs;

    public Transponder(String frequency) {
        this.frequency = frequency;
        this.programs = new ArrayList<>();
    }
    public String getFrequency() {
        return frequency;
    }

    public ArrayList<Program> getPrograms() {
        return programs;
    }

    public void appendProgram(Program p){
        programs.add(p);
    }
}
