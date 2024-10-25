module com.angular_manager {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires org.json;

    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.bootstrapicons;
    requires java.logging;
    requires java.desktop;
    requires io.reactivex.rxjava3;

    opens com.angular_manager to javafx.fxml;

    exports com.angular_manager;
}
