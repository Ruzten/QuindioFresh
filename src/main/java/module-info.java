module co.edu.uniquindio.poo.quindiofresh {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.quindiofresh to javafx.fxml;
    exports co.edu.uniquindio.poo.quindiofresh;
}