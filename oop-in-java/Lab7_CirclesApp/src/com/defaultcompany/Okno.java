package com.defaultcompany;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Okno {

    public static void main(String[] args) {
        ShowCollisions();
    }

    public static void InitiateMainProgram(){
        JFrame frame = new JFrame("Moje okno!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Panel());
        frame.setPreferredSize(new Dimension(800, 600));
        frame.pack();
        frame.setVisible(true);
    }

    public static void ShowCollisions(){
        SaveFile saveFile = new SaveFile();
        var list = saveFile.LoadFromFile();
        JFrame frame = new JFrame("Collisions");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new CollisionsPanel(list));
        frame.setPreferredSize(new Dimension(800, 600));
        frame.pack();
        frame.setVisible(true);
    }
}
