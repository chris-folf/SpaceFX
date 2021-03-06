package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {
    public Controller control;
    // Was coded by Christian C.
    // Now coded by Ashlesha K.

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Start the game!");
        Text Discrpt= new Text(300, 300, "Discription");
        Label space= new Label("\nWelcome to the space game!\n Your goal is to grab heart and exel though our \'challenging game\'.\nAvoid "
                + "being touched by the enemy. \n"
                + "To move use the standard W,A,S,D to go to up, left,down and right.\n"
                + "You can press R to reset the game. \n"
                + "Good luck!\n\n");
        Button btn = new Button();
        btn.setText("Start the game");

        VBox vbox = new VBox();

        vbox.getChildren().addAll(Discrpt,space, btn);



        Scene Scene1 = new Scene(vbox, 400, 400, Color.ALICEBLUE);
//        root.getChildren().addAll(Discrpt,btn);
        primaryStage.setScene(Scene1);
        primaryStage.show();



        btn.setOnAction(e->{
            control = new Controller(primaryStage);

            int screenSizeX = 1280;
            int screenSizeY = 720;

            control.BuildStage(screenSizeX, screenSizeY);
            primaryStage.show();

        });
    }

    public static void main(String[] args) {
        launch(args);
    }

}

