package dhbw.swe;

import java.util.List;

public class Leaf extends AbstractNode {

    public Leaf(String value) {
        super(value);
    }

    @Override
    public String toStr() {
        String formatString;
        formatString = "%" + (layer * 2) + "s";
        System.out.printf (formatString, "");
        System.out.println (" - " + super.getValue());
        return null;
    }
}
