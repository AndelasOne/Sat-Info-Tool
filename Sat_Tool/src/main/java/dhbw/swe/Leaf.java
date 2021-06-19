/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 12.06.2021, Samstag
 *
 * Copyright (c) 2021 DHBW Stuttgart
 **/

package dhbw.swe;

import java.util.List;
import java.util.Map;

public class Leaf<V> extends AbstractNode< V> {
    V value;

    /**
     *
     * @param value value to store in this leaf
     */
    public Leaf(V value) {
        this.value = value;
    }

    @Override
    public boolean isArray() {
        return false;
    }

    @Override
    public List<AbstractNode<V>> getArrayElements() {
        return null;
    }

    @Override
    public Map<String, AbstractNode<V>> getStructPairs() {
        return null;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public boolean isStruct() {
        return false;
    }
}
