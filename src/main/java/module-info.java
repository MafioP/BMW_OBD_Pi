module org.openjfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens me.bmwpi to javafx.fxml;
    exports me.bmwpi;
    exports me.bmwpi.controller;
    opens me.bmwpi.controller to javafx.fxml;
}
