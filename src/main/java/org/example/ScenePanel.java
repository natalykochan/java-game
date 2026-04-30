package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ScenePanel extends JPanel implements KeyListener {
    private Player player;

    public ScenePanel(int x, int y, int width, int height){
        this.setBounds(x,y,width,height);
        this.setBackground(Color.lightGray);
        this.setLayout(null); //creating background

        this.setFocusable(true);//allows to receive key inputs
        this.addKeyListener(this);

        this.player= new Player(50,50); //creating the player ints the scene
        movePlayer();

    }


    @Override
    public void keyPressed(KeyEvent e){ //listener - checks for button pressers
        int keyCode= e.getKeyCode();
        System.out.println("Key pressed: "+keyCode);

        if(keyCode == KeyEvent.VK_1){ // when the user press 1- moves right
            this.player.setDirection(Player.RIGHT);
        }else if (keyCode == KeyEvent.VK_2){ //when the user press 2- moves left
            this.player.setDirection(Player.LEFT);
        }else if (keyCode == KeyEvent.VK_3){//when the user press 3- moves up
            this.player.setDirection(Player.UP);
        }else if (keyCode == KeyEvent.VK_4){//when the user press 4- moves down
            this.player.setDirection(Player.DOWN);
        }else if (keyCode == KeyEvent.VK_0){//when the user press 0- stops moving
        this.player.setDirection(Player.STAY_STILL);}
    }
    @Override
    public void keyTyped(KeyEvent e){
    }
    @Override
    public void keyReleased(KeyEvent e){
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

    protected void paintComponent(Graphics graphics){ //build in function in JPanel- paints the visual picture
        super.paintComponent(graphics);
        this.player.paint(graphics);

    }
}
