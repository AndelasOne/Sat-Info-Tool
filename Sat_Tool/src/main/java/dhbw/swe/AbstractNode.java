/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 12.06.2021, Samstag
 * Copyright (c) 2021 DHBW Stuttgart
 **/

package dhbw.swe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractNode<T> {
    private T value;
    List<Leaf<T>> leafs = new ArrayList<>();
    List<Composite<T>> composites = new ArrayList<>();

    AbstractNode(T value){
        this.value = value;
    }

    public List<Leaf<T>> getLeafs(){
        return leafs;
    }

    public List<Composite<T>> getComposites(){
        return composites;
    }

    public T getValue(){
        return this.value;
    }
}
