package org.example;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ScenePanel extends JPanel {
    private Cat player;
    private Platforms[] platformsArr = new Platforms[5];
    private boolean gameStarted = false;

    public ScenePanel(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setBackground(Color.lightGray);
        this.setLayout(null);
        this.setFocusable(true);

        this.player = new Cat(225, 300);
        this.addKeyListener(new MyKeyListener(this.player));

        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            // creates platforms one above another.
            this.platformsArr[i] = new Platforms(random.nextInt(350), 300 - (i * 100), Color.GREEN);
        }

        startGameLoop();
    }

    private void startGameLoop() {
        new Thread(() -> {
            Random random = new Random();
            while (true) {
                player.move();


                if (!gameStarted) {
                    if (player.getY() > 325) {
                        player.setY(325); //so it won't fall from the very start
                        player.setDirection(Cat.STAY_STILL);
                    }
                    if (player.getDy() < 0){
                        gameStarted = true; //game starts.
                    }
                }

                if (player.getDy() > 0) { //so the cat won't get stuck in the head we check if he touches the platform only when he's landing
                    for (int i = 0; i < platformsArr.length; i++) {
                        Rectangle pRect = new Rectangle(player.getX(), player.getY(), 50, 50);
                        Rectangle platRect = new Rectangle(platformsArr[i].getX(), platformsArr[i].getY(), 100, 20);
                        if (pRect.intersects(platRect)) player.setDirection(Cat.UP); //intresect- checks if the two touching.
                    }
                }


                if (player.getY() < 200) {
                    int diff = 200 - player.getY();
                    player.setY(200);
                    for (int i = 0; i < platformsArr.length; i++) {
                        platformsArr[i].setY(platformsArr[i].getY() + diff);
                        if (platformsArr[i].getY() > 400) { //if the platform got down from the screen
                            platformsArr[i].setY(-20); //put her again at the top of the screen!!
                            platformsArr[i].setX(random.nextInt(350)); // and at a random x
                            int chance = random.nextInt(5);
                            if (chance == 0) { //random platform color will be chosen
                                platformsArr[i].setColor(Color.RED);
                            } else {
                                platformsArr[i].setColor(Color.GREEN);
                            }
                        }
                    }
                }

                for (int i = 0; i < platformsArr.length; i++) {
                    platformsArr[i].update(); // updates the platforms movement
                }


                if (gameStarted && player.getY() > 400) {
                    System.out.println("loser"); //if you fell down then you have lost the game
                    break;
                }

                this.repaint();
                try {
                    Thread.sleep(15);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        player.paint(graphics);
        for (int i = 0; i < platformsArr.length; i++) {
            if (platformsArr[i] != null) {
                platformsArr[i].paint(graphics); // paints the platform
            }
        }
    }
}