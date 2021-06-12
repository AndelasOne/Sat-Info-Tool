package dhbw.swe;

import java.util.List;

public class Composite extends AbtractNode {


    @Override
    public String toStr() {
        return null;
    }

    @Override
    protected void addAllChildren(List<AbtractNode> list) {
        for (AbtractNode child : children) {
            list.add(child);
            child.addAllChildren(list);
        }
    }
}
