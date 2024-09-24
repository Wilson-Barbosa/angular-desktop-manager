module com.angular_manager {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.angular_manager to javafx.fxml;
    exports com.angular_manager;
}
