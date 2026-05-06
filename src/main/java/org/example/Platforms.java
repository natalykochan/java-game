package org.example;
import java.awt.*;
import java.util.Random;

public class Platforms {
    private int x;
    private int y;
    private Color color;
    private int direction;
    public static final int RIGHT = 1;
    public static final int LEFT = 2;
    public static final int WIDTH = 20;
    public static final int LENGTH = 100;

    public Platforms(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;

        Random random = new Random();
        boolean result = random.nextBoolean();

        if (result == true) { //randomly picks if the platform moves right or left
            this.direction = RIGHT;
        } else {
            this.direction = LEFT;
        }
    }

    public void update() {
        if (this.direction == RIGHT) {
            this.x += 2;
        } else {
            this.x -= 2;
        }

        if (this.x <= 0) {
            this.direction = RIGHT;
        } else if (this.x + LENGTH >= 500) {
            this.direction = LEFT;
        }
    }

    public void paint(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.fillRect(this.x, this.y, LENGTH, WIDTH);
    }

    // getters and setters
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setColor(Color color) {
        this.color = color;
    }
}