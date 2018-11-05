package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

// Coded by Christian C.

class Controller {

    private Stage MainStage;
    private int numberOfHeart = 5;

    private Player player;
    private Enemy enemy;
    private Heart[] heart = new Heart[numberOfHeart];

    private Sub_control sub_control = new Sub_control();

    Controller(Stage Stage){
        this.MainStage = Stage;
    }


    void BuildStage(int ScreenSizeX, int ScreenSizeY){ // Build The main Game Stage
        ImageView imagePlayer = new  ImageView("file:./src/art/shipP.png"); // Art of the game
        ImageView imageEnemy = new  ImageView("file:./src/art/shipE.png");
        ImageView[] imageHeart = new ImageView[numberOfHeart];
        Text endText = new Text("This is a Text");

        ImageView BackGrown = new ImageView("file:./src/art/space.png");

        Group myGroup = new Group(BackGrown,imagePlayer, imageEnemy, endText);

        Scene myScene = new Scene(myGroup, ScreenSizeX, ScreenSizeY, Color.BEIGE);

        // Make the object and set it on screen
        player = new Player(ScreenSizeX, ScreenSizeY, 150, 110, myScene, imagePlayer, this);
        Enemy enemy = new Enemy(ScreenSizeX, ScreenSizeY, 150, 110, imageEnemy);
        for(int i = 0; i < heart.length; i++){
            imageHeart[i] = new ImageView("file:./src/art/heart.png");
            heart[i] = new Heart(ScreenSizeX, ScreenSizeY, 129, 130, imageHeart[i]);
            myGroup.getChildren().add(imageHeart[i]); // add heart to screen
        }



        sub_control.Starter(player, enemy, heart, MainStage, endText, numberOfHeart);
        MainStage.setScene(myScene);
    }

    public void reSet(){

        //System.out.println("Test");

        //MainStage.close();
        sub_control.resetTimer();

        // Reset the position of all the object on screen
        //player.setDefault();
        //enemy.setDefault();
        //System.gc();
        //BuildStage(1280, 720);
        player.changeKey(false);
        player.setScore(-player.getScore());

        sub_control.StartTimer();
        //MainStage.show();
    }




}
