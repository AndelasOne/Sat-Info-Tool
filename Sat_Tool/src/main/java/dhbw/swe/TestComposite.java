package dhbw.swe;

import java.util.List;

/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 12.06.2021, Samstag
 * Copyright (c) 2021 DHBW Stuttgart
 **/
public class TestComposite {
    public static void main(String[] args) {
        System.out.println("Test Composite\n");
        Composite<String> comp1 = new Composite<>("Satellit A", key);
        Composite<String> comp11 = new Composite<>("Transponder A", key);
        Composite<String> comp12 = new Composite<>("Transponder B", key);
        Leaf<String> leaf111 = new Leaf<>("20 Radio Programme");
        Leaf<String> leaf112 = new Leaf<>("10 Fernseh Programme");
        Leaf<String> leaf121 = new Leaf<>("1 Radio Programme");
        Leaf<String> leaf122 = new Leaf<>("100 Radio Programme");

        comp1.addComposite(comp11);
        comp1.addComposite(comp12);
        comp11.addLeaf(leaf111);
        comp11.addLeaf(leaf112);
        comp12.addLeaf(leaf121);
        comp12.addLeaf(leaf122);

        // Output
        printTree(comp1);
    }

    public static void printTree(AbstractNode<String, String> node) {
        List<Leaf<String, String>> leafs = node.getLeafs();
        List<Composite<String, String>> composites = node.getComposites();
        System.out.println("+" + node.value);
        for (Leaf<String, String> leaf : leafs) {
            System.out.println("- " + leaf.value);
        }
        for (Composite<String, String> composite : composites) {
            System.out.println("+ " + composite.value);
            printTree(composite);
        }
    }
}
