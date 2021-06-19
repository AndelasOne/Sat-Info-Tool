package outputs;

import dhbw.swe.AbstractNode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.util.Map;

public class PrimaryController {

    public TreeView<String> treeView;

    /**
     * Set data on the controller
     * automatically updates the view
     * @param data data to show
     */
    public void setData(AbstractNode<String> data) {
        TreeItem<String> root = new TreeItem<>();
        buildTree(data, root);
        treeView.setShowRoot(false);
        treeView.setRoot(root);
    }

    /**
     * Recursively build the Treeview
     * @param data Node to represent
     * @param root the next root node
     */
    private void buildTree(AbstractNode<String> data, TreeItem<String> root) {
        if (data.isLeaf()) {
            TreeItem<String> item = new TreeItem<>(data.getValue());
            root.getChildren().add(item);
        } else if (data.isArray()) {
            int index = 0;
            for (AbstractNode<String> dataItem : data.getArrayElements()) {
                TreeItem<String> item = new TreeItem<>(index + ":");
                buildTree(dataItem, item);
                root.getChildren().add(item);
                index++;
            }
        } else if (data.isStruct()) {
            for (Map.Entry<String, AbstractNode<String>> entry : data.getStructPairs().entrySet()) {
                AbstractNode<String> value = entry.getValue();
                if (value.isLeaf()) {
                    TreeItem<String> item = new TreeItem<>(entry.getKey()+ ": " + value.getValue());
                    root.getChildren().add(item);
                } else {
                    TreeItem<String> item = new TreeItem<>(entry.getKey());
                    buildTree(entry.getValue(), item);
                    root.getChildren().add(item);
                }
            }
        }
    }
}
