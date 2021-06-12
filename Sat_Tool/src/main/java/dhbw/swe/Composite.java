package dhbw.swe;

import java.util.Iterator;


public class Composite extends AbstractNode {
    public Composite(String value) {
        super(value);
    }

    public void add(AbstractNode comp){
        this.children.add(comp);
    }

    @Override
    public String toStr() {
        String formatString;
        ++layer;
        formatString = "%" + (layer * 2) + "s";
        System.out.printf (formatString, ""); // Output of empty strings
        System.out.println ("+ " + super.getValue() + "");

        for(Iterator<AbstractNode> iter = children.iterator(); iter.hasNext();){
            AbstractNode node = (AbstractNode) (iter.next());
            node.toStr();
        }
        --layer;
        return null;
    }
}
