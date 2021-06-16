module dhbw.swe {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;

    opens dhbw.swe to javafx.fxml;
    exports dhbw.swe;
    exports outputs;
    opens outputs to javafx.fxml;
}