package dhbw.swe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArrayNode<V> extends AbstractNode<V> {

    private final List<AbstractNode<V>> elements = new ArrayList<>();

    public void addElement(AbstractNode<V> element){
        elements.add(element);
    }

    public int getSize(){
        return elements.size();
    }

    @Override
    public List<AbstractNode<V>> getArrayElements() {
        return elements;
    }

    @Override
    public Map<String, AbstractNode<V>> getStructPairs() {
        return null;
    }

    @Override
    public V getValue() {
        return null;
    }

    @Override
    public boolean isArray() {
        return true;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public boolean isStruct() {
        return false;
    }
}
