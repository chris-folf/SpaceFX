package sample;

// Used by Christian C.
// Collision code Base of Lab 7 pdf

import javafx.scene.effect.ColorInput;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Collision, game timer, and sub controller
public class Sub_control{
    private Stage MainStage;
    private Timer MainTimer;

    private Text text;

    private Player player;
    private Enemy enemy;

    private Heart[] heart;
    private int numberOfHeart;
    private int HeartLeft;


    void Starter(Player player, Enemy enemy, Heart[] hearts, Stage stage, Text text, int numberOfHeart){
        this.MainStage = stage;
        this.text = text;
        this.player = player;
        this.enemy = enemy;
        this.heart = hearts;
        this.numberOfHeart = numberOfHeart;
        HeartLeft = numberOfHeart; // Set number of Heart

        MainTimer = new Timer(100, new TimeHandler());
        MainTimer.start();
    }

    // Simple collision detection code
    private boolean checkCollision(int r1TopLeftX, int
            r1BottomRightX, int r1TopLeftY, int r1BottomRightY, int
                                           r2TopLeftX, int r2BottomRightX, int r2TopLeftY, int
                                           r2BottomRightY)
    {
        return r1TopLeftX < r2BottomRightX && r1BottomRightX >
                r2TopLeftX && r1TopLeftY < r2BottomRightY && r1BottomRightY >
                r2TopLeftY;
    }

    void StartTimer(){
        MainTimer.start();
    }

    void resetTimer(){

        MainTimer.stop(); // Stop timer
        // Reset the position of all the object on screen
        enemy.setDefault();
        player.setDefault();

        // Set endText off screen
        text.setY(enemy.LimitY + 100);
        text.setX(enemy.LimitY + 100);

        for(int i = 0; i < heart.length; i++){
            heart[i].RandomSet();
        }

        HeartLeft = numberOfHeart; //  set the number of heart back to  default

    }

    void StopTimer(){
        MainTimer.stop();
    }

    // End screen
    private void gameOver(){
        StopTimer();
        player.changeKey(true); // Stop player from moving
        text.setText("Game Over\nYour score is: " + player.getScore() + "\nPress R to reset");
        text.setFont(Font.font(50));
        text.setFill(Color.PURPLE);
        text.setX(enemy.LimitX / 2);
        text.setY(enemy.LimitY / 2);
        HeartLeft = numberOfHeart;
    }


    private  class TimeHandler implements ActionListener { // Timer Listener
        @Override
        public void actionPerformed(ActionEvent e) {
            if(HeartLeft == 0){
                gameOver();
            }

            // Timer for checking if the player has hit the Enemy or not
            if(checkCollision(player.getX(), player.getX() + 150, player.getY(), player.getY() + 110,
                    enemy.getX(), enemy.getX() + 150, enemy.getY(), enemy.getY() + 110)){
               // System.out.println("True");
                gameOver();
            }
            else {
                // Simile logic for the Enemy to follow the player

                int enemySpeed = 2; // Set enemy Speed

                if(player.getY() >= enemy.getY()) {
                    if ((enemy.getX() - player.getX()) >= 5) {
                        enemy.setX(enemy.getX() - enemySpeed);
                    }
                    else if ((enemy.getX() - player.getX()) <= -5){
                        enemy.setX(enemy.getX() + enemySpeed );
                    }
                }
                enemy.setY(enemy.getY() + enemySpeed);
                if(enemy.getY() > enemy.LimitY){
                    gameOver();
                }
            }
            for(int i = 0; i < heart.length; i++) { // For loop to check if the heart as been hit
                //  Check for player
                if (checkCollision(player.getX(), player.getX() + 150, player.getY(), player.getY() + 110,
                        heart[i].getX(), heart[i].getX() + 129, heart[i].getY(), heart[i].getY() + 130)) {
                    heart[i].setX(1500); // Set of heath of screen
                    HeartLeft -= 1; // remove one heart from screen
                    player.setScore(50); // Add 25 points if the player hir the heart
                    //System.out.println("True H");
                }
                // Check for enemy
                else if(checkCollision(enemy.getX(), enemy.getX() + 150, enemy.getY(), enemy.getY() + 110,
                        heart[i].getX(), heart[i].getX() + 129, heart[i].getY(), heart[i].getY() + 130)) {
                    heart[i].setX(1500);
                    HeartLeft -= 1; // remove one heart from screen
                    player.setScore(-25); // remove 25 points if the enemy hir the heart
                }
            }
            }
        }
    }

