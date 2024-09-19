package com.example.oasis_infobyte_task_2_number_guessing_game;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;
import java.util.Random;

public class HelloController extends HelloApplication {

    public javafx.scene.control.Label Prompt;
    public javafx.scene.control.Label attempts;
    @FXML
    private Button Exit;

    @FXML
    private Button Restart;

    @FXML
    private Button hints;
    @FXML
    public javafx.scene.control.Label score;

    @FXML
    private Button Submit;


    @FXML
    private Label Label;
    int Score=0;
    int Attempts=0;
    @FXML
    private TextField Txt_1;

    public void initialize() {
        generate();
        Prompt.setText("Guess a number between 1-100");
        score.setText("Score : 0");
        attempts.setText("Attempts : 0");
    }

    int k;
    public void generate() {
        Prompt.setText("Guess a number between 1-100");
        Random r1 = new Random();
         k = r1.nextInt(100+1);
        System.out.println(k);
    }

    @FXML
    void Submit(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.NONE);
        if (Txt_1.getText().isEmpty()) {
            a.setAlertType(Alert.AlertType.WARNING);
            a.setHeaderText(null);
            a.setTitle("Warning!!!");
            a.setContentText("Please enter a number first.");
            a.show();
        } else {
            try {

                int inputNumber = Integer.parseInt(Txt_1.getText());


                if (inputNumber == k) {
                    a.setAlertType(Alert.AlertType.CONFIRMATION);
                    a.setTitle("***Result***");
                    a.setContentText("Congrats!!!! Your Answer " + k + " is Correct ");
                    a.show();
                    generate();
                    Score = Score + 10;
                    score.setText("Score : " + Score);
                }

                else if (inputNumber < 1 || inputNumber > 100) {
                    a.setAlertType(Alert.AlertType.ERROR);
                    a.setContentText("Oh!!! Please enter a number between 1 and 100.");
                    a.show();
                    Attempts++;
                    attempts.setText("Attempts : "+Attempts);
                    if (Attempts >= 5) {
                        a.setAlertType(Alert.AlertType.ERROR);
                        a.setTitle("***Result***");
                        a.setHeaderText("You have reached the maximum attempts , " + " The correct answer is : "+k+" , Your total score is : "+Score);
                        a.show();
                        Restart(event);
                    }
                }

                else if (inputNumber > k) {
                    Prompt.setText("The number is less than " + inputNumber);
                    a.setTitle("***Attention***");
                    a.setAlertType(Alert.AlertType.INFORMATION);
                    a.setHeaderText("The number is less than "+inputNumber);
                    a.show();
                    Attempts++;
                    if (Attempts >= 5) {
                        a.setAlertType(Alert.AlertType.ERROR);
                        a.setTitle("***Attempts Over***");
                        a.setContentText("You have reached the maximum attempts , " + "The correct answer is : "+k+" , Your total score is : "+Score);
                        a.show();
                        Restart(event);
                    }
                    attempts.setText("Attempts : " + Attempts);
                }
                else if (inputNumber < k) {
                    Prompt.setText("The number is greater than " + inputNumber);
                    a.setTitle("***Attention***");
                    a.setAlertType(Alert.AlertType.INFORMATION);
                    a.setHeaderText("The number is greater than "+inputNumber);
                    a.show();
                    Attempts++;
                    if (Attempts >= 5) {
                        a.setAlertType(Alert.AlertType.ERROR);
                        a.setTitle("***Attempts Over***");
                        a.setContentText("You have reached the maximum attempts , "+ "The correct answer is : "+k+" , Your total score is : "+Score);
                        a.show();
                        Restart(event);

                    }
                    attempts.setText("Attempts : " + Attempts);
                }

            } catch (NumberFormatException e) {
                a.setAlertType(Alert.AlertType.ERROR);
                a.setTitle("***Invalid Input***");
                a.setContentText("Please enter a valid number.");
                a.show();
            }
        }

    }


    @FXML
    void hints(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.WARNING);
        if ((Integer.remainderUnsigned(k, 2)) == 0) {
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setTitle("***Hints***");
            a.setContentText("The Number is Even Number");
            a.show();
        } else {
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setTitle("***Hints***");
            a.setContentText("The Number is Odd Number");
            a.show();
        }

    }

    @FXML
    void Restart(ActionEvent event) {


            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }




    @FXML
    void Exit(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle("***Exit***");
        a.setHeaderText("Are you sure you want to exit this game?");
        ButtonType yesButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
        a.getButtonTypes().setAll(yesButton, noButton);
        Optional<ButtonType>result = a.showAndWait();
        if (result.isPresent() && result.get().getButtonData() == ButtonBar.ButtonData.YES) {
            Platform.exit();
        }


    }
}


