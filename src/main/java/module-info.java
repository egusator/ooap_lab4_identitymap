module com.example.ooap_lab4_identitymap {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ooap_lab4_identitymap to javafx.fxml;
    exports com.example.ooap_lab4_identitymap;
}