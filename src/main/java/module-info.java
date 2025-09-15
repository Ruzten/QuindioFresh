module co.edu.uniquindio.poo.quindiofresh {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens co.edu.uniquindio.poo.quindiofresh to javafx.fxml;
    opens co.edu.uniquindio.poo.quindiofresh.Model to javafx.fxml;
    exports co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas;
    opens co.edu.uniquindio.poo.quindiofresh.Model.ClasesConcretas to javafx.fxml;
}