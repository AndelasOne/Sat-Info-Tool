package outputs;

import java.io.IOException;
import javafx.fxml.FXML;
import outputs.App;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}