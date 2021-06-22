/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 12.06.2021, Samstag
 * <p>
 * Copyright (c) 2021 DHBW Stuttgart
 **/
package dhbw.swe;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StructNode<V> extends AbstractNode<V> {
    private final Map<String, AbstractNode<V>> nodeMap = new LinkedHashMap<>();

    public void addPair(String key, AbstractNode<V> value) {
        nodeMap.put(key, value);
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
        return nodeMap;
    }

    @Override
    public V getValue() {
        return null;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public boolean isStruct() {
        return true;
    }
}
