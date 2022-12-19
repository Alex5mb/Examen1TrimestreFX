module com.mycompany.examenfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.examenfx to javafx.fxml;
    exports com.mycompany.examenfx;
}
