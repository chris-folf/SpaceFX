package sample;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

import java.util.Random;


// Base of Space! code
// Coded by Christian C.

public class Enemy{ // Location of an art on the screen

    private int x; // Position of player/image
    private int y;

    public int LimitX; // Limit of player movement
    public int LimitY;
    private int offSetX;
    private int offSetY;

    private ImageView images;
    private boolean keys = false; //  Key control

    Enemy(int LimitX, int LimitY, int offSetX, int offSetY, ImageView images) {

        this.LimitX = LimitX; // Limit of player movement
        this.LimitY = LimitY;
        this.offSetX = offSetX;
        this.offSetY = offSetY;

        this.images = images;

        setDefault();
        //G_panel.addKeyListener(this);
    }

    public void setDefault(){
        Random ran  = new Random();
        this.x = ran.nextInt(LimitX - offSetX - 30); // Position of player
        this.y = 5;
        images.setX(x); // Set the position of image on screen
        images.setY(y);

    }

    public void setLimit(int x, int y){ // Set the limited of the player movement
        this.LimitX = x;
        this.LimitY = y;
    }

    // Getter
    int getX() {
        return x;
    }
    int getY(){
        return y;
    }

    // Setter
    void setX(int x){
        this.x = x;
        images.setX(x);
    }

    void setY(int y){
        this.y = y;
        images.setY(y);
    }


}


