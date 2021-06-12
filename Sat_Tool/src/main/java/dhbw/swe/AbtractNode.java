package dhbw.swe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbtractNode {


    List<AbtractNode> children = new ArrayList<>();
    public Iterator<AbtractNode> iterator(){
        List<AbtractNode> list = new ArrayList<>();
        list.add(this);
        addAllChildren(list);
        return list.iterator();
    }

    protected abstract void addAllChildren(List<AbtractNode> list);

    public abstract String toStr();
}
