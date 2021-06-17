package outputs;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PrimaryController {

    @FXML
    private Label label;

    public void setString(String string){
        label.setText(string);
    }
}
