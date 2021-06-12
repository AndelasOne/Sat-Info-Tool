package dhbw.swe;

/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 12.06.2021, Samstag
 * Copyright (c) 2021 DHBW Stuttgart
 **/
public class TestComposite {
    public static void main(String[] args) {
        System.out.println ("Test Composite\n");
        Composite comp1 = new Composite("Satellit A");
        Composite comp11 = new Composite("Transponder A");
        Composite comp12 = new Composite("Transponder B");
        Leaf leaf111 = new Leaf("20 Radio Programme");
        Leaf leaf112 = new Leaf("10 Fernseh Programme");
        Leaf leaf121 = new Leaf("1 Radio Programme");
        Leaf leaf122 = new Leaf("100 Radio Programme");

        comp1.add(comp11);
        comp1.add(comp12);
        comp11.add(leaf111);
        comp11.add(leaf112);
        comp12.add(leaf121);
        comp12.add(leaf122);

        // Output
        comp1.toStr();
    }
}
