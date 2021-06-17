package plugins;

/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 17.06.2021, Donnerstag
 * Copyright (c) 2021 DHBW Stuttgart
 **/
public class Program {
    private final String type;
    private final String frequency;
    private int amount;

    public Program(String type, String frequency, int amount) {
        this.type = type;
        this.amount = amount;
        this.frequency = frequency;
    }

    public void increaseAmount(){
        amount++;
    }
    public String getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }
}
