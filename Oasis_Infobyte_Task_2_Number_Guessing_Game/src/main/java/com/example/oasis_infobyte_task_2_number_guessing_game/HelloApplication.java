package com.example.oasis_infobyte_task_2_number_guessing_game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;


public class HelloApplication extends Application {
    private MediaPlayer mediaPlayer;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 540);
        stage.setTitle("Number Guessing Game !!!");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
        String filePath = "C:\\Users\\BRATI SUNDOR BISWAS\\IdeaProjects\\Oasis_Infobyte_Task_2_Number_Guessing_Game\\src\\main\\java\\com\\example\\oasis_infobyte_task_2_number_guessing_game\\Number_Guessing.mp3";
        File file = new File(filePath);

        if (file.exists()) {
            try {
                Media sound = new Media(file.toURI().toString());
                mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
                mediaPlayer.play();
                System.out.println("Music started successfully!");
            } catch (Exception e) {
                System.out.println("Error loading media: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Sound file not found: " + file.getAbsolutePath());
        }
        stage.setOnCloseRequest(event -> {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                System.out.println("Music stopped.");
            }
        });

    }




    public static void main(String[] args) {
        launch(args);

    }
}