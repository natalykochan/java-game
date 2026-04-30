package org.example;
import java.awt.*;

public class Player {
    private int x;
    private int y;
    private int direction;
    public static  final int STAY_STILL= 0; //when the user press 0- stops moving
    public static final int RIGHT= 1; // when the user press 1- moves right
    public static final int LEFT= 2; //when the user press 2- moves left
    public static final int UP= 3; //when the user press 3- moves up
    public static final int DOWN= 4; //when the user press 4- moves down
    public static final int SIZE= 50;

    public Player(int x,int y){
        this.x= x;
        this.y= y;
        this.direction= STAY_STILL;
    }


    public void paint(Graphics graphics){
        graphics.setColor(Color.MAGENTA);
        graphics.fillRect(this.x,this.y,SIZE,SIZE);
    }
    public void setDirection(int newDirection){
        this.direction= newDirection;
    }

    public void move(){ //we dont need to add the STAY_STILL in here because it should be unknown
        // for the movePlayer()- if its unknown the compiler just stops the x/y from changing
        switch(this.direction){
            case RIGHT -> this.x++;
            case LEFT -> this.x--;
            case UP -> this.y--;
            case DOWN -> this.y++;
        }
    }


}
