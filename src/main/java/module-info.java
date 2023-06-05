module ch.hftm {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens ch.hftm to javafx.fxml;

    exports ch.hftm;
}
