package org.example;
import java.awt.*;

public class Cat {
    private int x, y, direction;
    private int dy = 0;
    private final int GRAVITY = 1;
    public static final int STAY_STILL = 0, RIGHT = 1, LEFT = 2, UP = 3, DOWN = 4, SIZE = 50;

    public Cat(int x, int y) {
        this.x = x;
        this.y = y;
        this.direction = STAY_STILL;
    }

    public void paint(Graphics graphics) {
        graphics.setColor(Color.MAGENTA);
        graphics.fillRect(this.x, this.y, SIZE, SIZE);
    }

    public void setDirection(int newDirection) {
        if (newDirection == UP) {
            //you can jump only if the player stands still or falls
            if (this.dy >= 0) {
                this.dy = -15;
            }
        } else {
            this.direction = newDirection;
        }
    }

    public void move() {
        if (this.direction == RIGHT) this.x += 4;
        else if (this.direction == LEFT) this.x -= 4;

        this.y += dy;
        dy += GRAVITY;
    }

    // Getters & Setters
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getDy() {
        return dy;
    }
}
