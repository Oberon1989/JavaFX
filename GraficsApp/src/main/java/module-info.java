module com.Oberon1989 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.Oberon1989 to javafx.fxml;
    exports com.Oberon1989;
}