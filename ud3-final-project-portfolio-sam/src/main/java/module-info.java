module cs112.ud2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens cs112.ud2 to javafx.fxml;
    exports cs112.ud2;
    exports cs112.ud2.models;
    opens cs112.ud2.models to javafx.fxml;
    exports cs112.ud2.controllers;
    opens cs112.ud2.controllers to javafx.fxml;

//    opens cs112.lab09 to javafx.fxml;
//    exports cs112.lab09;
//    exports cs112.lab09.models;
//    opens cs112.lab09.models to javafx.fxml;
//    exports cs112.lab09.controllers;
//    opens cs112.lab09.controllers to javafx.fxml;
}