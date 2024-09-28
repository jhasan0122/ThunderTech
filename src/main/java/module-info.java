module com.example.thundertech {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.thundertech to javafx.fxml;
    exports com.example.thundertech;
}