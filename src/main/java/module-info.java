module nebrija.Criptofolks {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.desktop;
	requires javafx.graphics;
	requires java.sql;
	requires javafx.base;

    opens nebrija.Criptofolks to javafx.fxml;
    opens nebrija.Criptofolks.modelo;
    exports nebrija.Criptofolks;
}
