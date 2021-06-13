package dhbw.swe;

import java.util.Iterator;


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
