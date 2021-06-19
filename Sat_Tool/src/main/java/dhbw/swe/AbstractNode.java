/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 12.06.2021, Samstag
 * Copyright (c) 2021 DHBW Stuttgart
 **/

package dhbw.swe;

import java.util.*;

/**
 * Abstract Node is an abstract class used to realise composite pattern
 *
 * @param <V> value used in a leaf or a composite
 */
public abstract class AbstractNode<V> {
    protected final Map<String, Leaf<V>> leafMap = new HashMap<>();
    protected final Map<String, StructNode<V>> compositeMap = new HashMap<>();

    protected Set<String> keys = new HashSet<>();

    public abstract boolean isLeaf();

    public abstract boolean isStruct();

    public abstract boolean isArray();

    public abstract List<AbstractNode<V>> getArrayElements();

    public abstract Map<String, AbstractNode<V>> getStructPairs();

    public abstract V getValue();
}
