/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 12.06.2021, Samstag
 *
 * Copyright (c) 2021 DHBW Stuttgart
 **/
package dhbw.swe;

public class Composite<T> extends AbstractNode<T> {
    public Composite(T value) {
        super(value);
    }

    public void addLeaf(Leaf<T> leaf){
        leafs.add(leaf);
    }

    public void addComposite(Composite<T> composite){
        composites.add(composite);
    }

    public void removeLeaf(int index){
        leafs.remove(index);
    }

    public void removeComposite(int index){
        composites.remove(index);
    }

}
