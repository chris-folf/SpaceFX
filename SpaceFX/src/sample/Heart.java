package sample;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

import java.util.Random;


// Base of Space! code
// Coded by Christian C.

public class Heart{ // Location of an art on the screen

    private int x; // Position of player/image
    private int y;

    private int LimitX; // Limit of player movement
    private int LimitY;
    private int offSetX;
    private int offSetY;

    private ImageView images;
    private boolean keys = false; //  Key control

    Heart(int LimitX, int LimitY, int offSetX, int offSetY, ImageView images) {


        this.LimitX = LimitX; // Limit of player movement
        this.LimitY = LimitY;
        this.offSetX = offSetX;
        this.offSetY = offSetY;

        this.images = images;

        RandomSet();

        //G_panel.addKeyListener(this);
    }

    public void setLimit(int x, int y){ // Set the limited of the player movement
        this.LimitX = x;
        this.LimitY = y;
    }

    void setX(int x){
        this.x = x;
        images.setX(x);
    }

    public void RandomSet(){
        Random ran = new Random(); // Randomly put heart on screen
        x = ran.nextInt(800) + 50;
        y = ran.nextInt(400) + 100;

        images.setX(x); // Set the position of image on screen
        images.setY(y);
    }

    // Getter
    int getX() {
        return x;
    }
    int getY(){
        return y;
    }

}


