package org.example;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {
    private Cat player;

    public MyKeyListener(Cat player){
        this.player= player;
    }
    @Override
    public void keyPressed(KeyEvent e){ //listener - checks for button pressers
        int keyCode= e.getKeyCode();
        System.out.println("Key pressed: "+keyCode);

        if(keyCode == KeyEvent.VK_RIGHT){ // when the user press 1- moves right
            this.player.setDirection(Cat.RIGHT);
        }else if (keyCode == KeyEvent.VK_LEFT){ //when the user press 2- moves left
            this.player.setDirection(Cat.LEFT);
        }else if (keyCode == KeyEvent.VK_UP){//when the user press 3- moves up
            this.player.setDirection(Cat.UP);
        }else if (keyCode == KeyEvent.VK_DOWN){//when the user press 4- moves down
            this.player.setDirection(Cat.DOWN);
        }else if (keyCode == KeyEvent.VK_SPACE){//when the user press 0- stops moving
            this.player.setDirection(Cat.STAY_STILL);}
    }
    @Override
    public void keyTyped(KeyEvent e){
    }
    @Override
    public void keyReleased(KeyEvent e){
    }

}
