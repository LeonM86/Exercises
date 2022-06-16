module ch.csbe.modul404.personregistration {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens ch.csbe.modul404.personregistration to javafx.fxml;
    exports ch.csbe.modul404.personregistration;
}