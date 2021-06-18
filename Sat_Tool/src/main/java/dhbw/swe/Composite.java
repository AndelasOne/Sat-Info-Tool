/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 12.06.2021, Samstag
 * <p>
 * Copyright (c) 2021 DHBW Stuttgart
 **/
package dhbw.swe;

public class Composite<V> extends AbstractNode<V> {
    public Composite(V value) {
        super(value);
    }

    public void addLeaf(String key, Leaf<V> leaf) {
        if (!keys.contains(key)) {
            leafMap.put(key, leaf);
        }
    }

    public void addComposite(String key, Composite<V> composite) {
        if(!keys.contains(key)){
            compositeMap.put(key, composite);
        }
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public boolean isComposite() {
        return true;
    }
//    public void removeLeaf(int index){
//        leafs.remove(index);
//    }
//
//    public void removeComposite(int index){
//        composites.remove(index);
//    }

}
