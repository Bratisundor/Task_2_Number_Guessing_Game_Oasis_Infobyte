module com.example.oasis_infobyte_task_2_number_guessing_game {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.media;


    opens com.example.oasis_infobyte_task_2_number_guessing_game to javafx.fxml;
    exports com.example.oasis_infobyte_task_2_number_guessing_game;
}