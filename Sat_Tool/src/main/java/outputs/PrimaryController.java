package outputs;

import dhbw.swe.AbstractNode;
import dhbw.swe.Composite;
import dhbw.swe.Leaf;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class PrimaryController {

    public TreeView<String> treeView;

    public void setData(AbstractNode<String> data) {
        TreeItem<String> root = new TreeItem<>(data.getValue());
        buildTree(data, root);
        treeView.setRoot(root);
    }

    private void buildTree(AbstractNode<String> data, TreeItem<String> root) {
        for (Leaf<String> leaf : data.getLeafs()) {
            TreeItem<String> item = new TreeItem<>(leaf.getValue());
            root.getChildren().add(item);
        }
        for (Composite<String> composite : data.getComposites()) {
            TreeItem<String> item = new TreeItem<>(composite.getValue());
            buildTree(composite, item);
            root.getChildren().add(item);
        }
    }
}
