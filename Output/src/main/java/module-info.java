module outputs {
    requires javafx.controls;
    requires javafx.fxml;
    requires main;

    opens outputs to javafx.fxml;
    exports outputs;
}