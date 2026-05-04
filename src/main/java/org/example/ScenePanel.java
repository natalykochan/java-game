package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class ScenePanel extends JPanel{
    private Cat player;
    private Platforms[] platformsArr= new Platforms[5];

    public ScenePanel(int x, int y, int width, int height){
        this.setBounds(x,y,width,height);
        this.setBackground(Color.lightGray);
        this.setLayout(null); //creating background
        this.setFocusable(true);//allows to receive key inputs


        this.player= new Cat(50,325); //creating the player ints the scene
        this.addKeyListener(new MyKeyListener(this.player));

        Random random= new Random();
        int spacing= 60; //spacing between platforms
        for (int i = 0; i < 5; i++) { //creating platforms with a random placing
            int platformX= random.nextInt(401);
            int platformY= i * spacing +50;

            Color platformColor= Color.GREEN;
            if (random.nextInt(5)==0){ //0-4 chances the platform will be breakable.
                platformColor= Color.RED;
            }

            this.platformsArr[i]= new Platforms(platformX, platformY, platformColor);

        }
        movePlatforms();
        movePlayer();

    }
    public void movePlayer(){
        new Thread(() ->{
            while (true){
                this.player.move();
                this.repaint(); //so we will see the movement
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    public void movePlatforms(){
        new Thread(() ->{
            while (true){
                for (int i = 0; i < platformsArr.length ; i++) {
                    if (platformsArr[i] != null){
                        platformsArr[i].update();
                    }
                }
                this.repaint(); //so we will see the movement
                try {
                    Thread.sleep(15);
                } catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    protected void paintComponent(Graphics graphics){ //build in function in JPanel- paints the visual picture
        super.paintComponent(graphics);
        this.player.paint(graphics);

        for (int i = 0; i <platformsArr.length ; i++) { //paints the platforms arr
            if (platformsArr[i] != null){
                platformsArr[i].paint(graphics);
            }
        }

    }
}
