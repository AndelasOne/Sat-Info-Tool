module dhbw.swe {
    requires javafx.controls;
    requires javafx.fxml;

    opens dhbw.swe to javafx.fxml;
    exports dhbw.swe;
}