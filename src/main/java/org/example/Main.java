package org.example;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static final int WINDOW_WIDTH= 500;
    public static final int WINDOW_HEIGHT= 400;

    static void main() {
        JFrame window= new JFrame();
        window.setSize(WINDOW_WIDTH,WINDOW_HEIGHT); //creating window
        window.setResizable(false); //the user cant change window's size
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // now the x ends the running program
        window.setLayout(null);
        window.setLocationRelativeTo(null); //the window opens in the center of the screen

        window.add(new ScenePanel(0,0,WINDOW_WIDTH,WINDOW_HEIGHT)); //paints background

        window.setVisible(true);

    }
}
