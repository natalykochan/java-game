package org.example;

import java.awt.*;
import java.util.Random;

public class Platforms {
    private int x;
    private int y;
    private Color color;
    private  int direction;
    public static final int RIGHT= 1;
    public static final int LEFT= 2;
    public static final int WIDTH= 20;
    public static final int LENGTH= 100;


    public Platforms(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color= color;

        Random random= new Random();
        if (random.nextBoolean()){
            this.direction= RIGHT;
        }else {
            this.direction= LEFT;
        }

    }

    public void update(){
        switch (this.direction){
            case RIGHT -> this.x += 2;
            case LEFT -> this.x -= 2;
        }
        if (this.x<=0){  //so the platforms won't get out of the screen.
            this.direction= RIGHT;
        }else if (this.x+LENGTH >=500){
            this.direction= LEFT;
        }
    }

    public void paint(Graphics graphics){
        graphics.setColor(this.color); //in
        graphics.fillRect(this.x,this.y,LENGTH,WIDTH);
    }


}
