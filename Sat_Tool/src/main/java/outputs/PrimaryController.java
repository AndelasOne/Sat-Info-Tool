package outputs;

import java.io.IOException;
import javafx.fxml.FXML;
import outputs.App;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
