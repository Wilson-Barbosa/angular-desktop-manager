module com.angular_manager {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires org.json;

    opens com.angular_manager to javafx.fxml;
    exports com.angular_manager;
}
