package dhbw.swe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractNode {
    static int layer = 0;
    private String value = "";

    List<AbstractNode> children = new ArrayList<>();

    public AbstractNode(String value) {
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
    public abstract String toStr();
}
