module com.javeriana.Study_With_Me {
    requires javafx.controls;
    requires javafx.fxml;
    requires jbcrypt;
    opens com.javeriana.Study_With_Me.controller to javafx.fxml;
    exports com.javeriana.Study_With_Me.controller;
    exports com.javeriana.Study_With_Me.model.User_model;
    opens com.javeriana.Study_With_Me.model.User_model to javafx.fxml;
}