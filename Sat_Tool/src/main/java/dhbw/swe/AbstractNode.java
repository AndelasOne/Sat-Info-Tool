/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 12.06.2021, Samstag
 * Copyright (c) 2021 DHBW Stuttgart
 **/

package dhbw.swe;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract Node is an abstract class used to realise composite pattern
 * @param <T> value used in a leaf or a composite
 */
public abstract class AbstractNode<T> {
    private T value;
    List<Leaf<T>> leafs = new ArrayList<>();
    List<Composite<T>> composites = new ArrayList<>();

    AbstractNode(T value){
        this.value = value;
    }

    /**
     * get all existing leafs of a composite
     * @return list of leafs
     */
    public List<Leaf<T>> getLeafs(){
        return leafs;
    }

    /**
     * get all existing composite-children of a composite
     * @return list of composites
     */
    public List<Composite<T>> getComposites(){
        return composites;
    }

    /**
     * get the value of a leaf / composite
     * @return value
     */
    public T getValue(){
        return this.value;
    }
}
