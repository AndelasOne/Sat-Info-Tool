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
 * @param <V> value used in a leaf or a composite
 */
public abstract class AbstractNode<V> {
    public final V value;
    protected final Map<String, Leaf<V>> leafMap = new HashMap<>();
    protected final Map<String, Composite<V>> compositeMap = new HashMap<>();

    protected Set<String> keys = new HashSet<>();

    public abstract boolean isLeaf();
    public abstract boolean isComposite();

    protected AbstractNode(V value) {
        this.value = value;
    }

    /**
     * get all existing leafs of a composite
     * @return list of leafs
     */
    public Map<String, Leaf<V>> getLeafs(){
        return leafMap;
    }

    /**
     * get all existing composite-children of a composite
     * @return list of composites
     */
    public Map<String, Composite<V>> getComposites(){
        return compositeMap;
    }
}
