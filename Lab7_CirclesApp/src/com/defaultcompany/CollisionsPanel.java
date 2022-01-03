package com.defaultcompany;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CollisionsPanel extends JPanel{
    private ArrayList<Position> positions;
    private int size = 20;
    private Timer timer;
    private final int DELAY = 16;

    public CollisionsPanel(ArrayList<Position> positions) {
        this.positions = positions;
        setBackground(Color.BLACK);
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (var k : positions) {
            g.setColor(Color.GREEN);
            g.drawOval(k.x, k.y, k.size, k.size);
        }
        g.setColor(Color.YELLOW);
        g.drawString(Integer.toString(positions.size()),40,40);
    }
}
