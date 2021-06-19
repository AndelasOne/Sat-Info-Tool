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
    /**
     * @return true if this node is a leaf node
     */
    public abstract boolean isLeaf();

    /**
     * @return true of this node is a struct node
     */
    public abstract boolean isStruct();

    /**
     * @return true if this node is an array node
     */
    public abstract boolean isArray();

    /**
     * @return array elements if this is a leaf node else null
     */
    public abstract List<AbstractNode<V>> getArrayElements();

    /**
     * @return Map of Key - Node pairs if this node is a struct node
     */
    public abstract Map<String, AbstractNode<V>> getStructPairs();

    /**
     * @return value if this node is a leaf node
     */
    public abstract V getValue();
}
