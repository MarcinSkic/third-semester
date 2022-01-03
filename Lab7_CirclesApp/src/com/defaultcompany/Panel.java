package com.defaultcompany;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel {
    private ArrayList<Kula> listaKul;
    private int size = 20;
    private Timer timer;
    private final int DELAY = 16;

    public Panel() {
        listaKul = new ArrayList<>();
        setBackground(Color.BLACK);
        addMouseListener(new Event());
        addMouseWheelListener(new Event());
        timer = new Timer(DELAY, new Event());
        timer.start();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Kula k : listaKul) {
            g.setColor(k.color);
            g.drawOval(k.x, k.y, k.size, k.size);
        }
        g.setColor(Color.YELLOW);
        g.drawString(Integer.toString(listaKul.size()),40,40);
    }
    private class Event implements MouseListener,
            ActionListener, MouseWheelListener {
        @Override
        public void mouseClicked(MouseEvent e) {
        }
        @Override
        public void mousePressed(MouseEvent e) {
            listaKul.add(new Kula(e.getX(), e.getY(), size));
            repaint();
        }
        @Override
        public void mouseWheelMoved(MouseWheelEvent e){
            for (var x : listaKul) {
                x.size += (e.getPreciseWheelRotation()*2);

                x.update();
            }

        }
        @Override
        public void mouseReleased(MouseEvent e) {

                listaKul.get(listaKul.size()-1).size = (e.getX()/10);

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            timer.start();
        }
        @Override
        public void mouseExited(MouseEvent e) {
            for (var k: listaKul) {
                timer.stop();
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            for (Kula k : listaKul) {
                k.update();

            }
            repaint();
        }
    }
    public class Kula {
        public int x, y, size, xspeed, yspeed;
        public Color color;
        private final int MAX_SPEED = 5;
        SaveFile saveFile = new SaveFile();
        public Kula(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
            color = new Color((float) Math.random(), (float)
                    Math.random(), (float) Math.random());
            do{
                xspeed = (int) (Math.random() * MAX_SPEED * 2 -
                        MAX_SPEED);
            }while(xspeed == 0);
            do{
                yspeed = (int) (Math.random() * MAX_SPEED * 2 -
                        MAX_SPEED);
            }while (yspeed==0);

        }
        public void zderzenie(Kula k) {
            //wektor normalny do powierzchni kuli
            Wektor normalny = new Wektor(x, y, k.x, k.y);
            normalny = normalny.normalny();
            //wektor styczny do powierzchni kuli
            Wektor styczny = normalny.prostopadly();

            //prędkości przed zderzeniem
            Wektor v1 = new Wektor(xspeed, yspeed);
            Wektor v2 = new Wektor(k.xspeed, k.yspeed);

            //rzut prędkości na wektor normalny (składowa prędkości równoległa do normalnej)
            double v1n = normalny.iloczynSkalarny(v1);
            double v2n = normalny.iloczynSkalarny(v2);

            //zderzenie sprężyste wzdłuż normalnej
            //składowe prędkości po zderzeniu równodległe do normalnej
            double v1n2 = (v1n * (size - k.size) + 2 * k.size * v2n) / (size + k.size);
            double v2n2 = (v2n * (k.size - size) + 2 * size * v1n) / (size + k.size);

            //składowa normalna prędkości
            Wektor v12n = normalny.mnozPrzezSkalar(v1n2);
            Wektor v22n = normalny.mnozPrzezSkalar(v2n2);

            //rzut prędkości na wektor styczny (składowa prędkości równoległa do stycznej)
            //ta składowa się nie zmienia
            double v1s = styczny.iloczynSkalarny(v1);
            double v2s = styczny.iloczynSkalarny(v2);

            //składowa styczna prędkości
            Wektor v12s = styczny.mnozPrzezSkalar(v1s);
            Wektor v22s = styczny.mnozPrzezSkalar(v2s);

            //nowe prędkości
            Wektor v12 = v12n.dodaj(v12s);
            Wektor v22 = v22n.dodaj(v22s);

            //konwersja na prędkości całkowite - ceil i floor aby uniknąć zaokrągleń do 0
            xspeed = (int) (v12.x > 0 ? Math.ceil(v12.x) : Math.floor(v12.x));
            yspeed = (int) (v12.y > 0 ? Math.ceil(v12.y) : Math.floor(v12.y));
            k.xspeed = (int) (v22.x > 0 ? Math.ceil(v22.x) : Math.floor(v22.x));
            k.yspeed = (int) (v22.y > 0 ? Math.ceil(v22.y) : Math.floor(v22.y));
        }
        public void update() {
            x += xspeed;
            y += yspeed;
            if (x <= 0 || x >= getWidth()) {
                xspeed = -xspeed;
            }
            if (y <= 0 || y >= getHeight()) {
                yspeed = -yspeed;
            }
            for (var k: listaKul) {
                if(k.equals(this)){
                    break;
                }
                float roznica_x = x-k.x;
                float roznica_y = y-k.y;
                float odleglosc_srodkow =(float) Math.sqrt(Math.pow(roznica_x,2)+Math.pow(roznica_y,2));

                if(odleglosc_srodkow <= (size/2 + k.size/2)){
                    zderzenie(k);
                    saveFile.SaveLastPositions(this,k);
                }

            }
        }
        public void changeColor(){
            color = new Color((float) Math.random(), (float)
                    Math.random(), (float) Math.random());
        }
    }
    private class Wektor {
        public double x;
        public double y;

        public Wektor(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public Wektor(double xp, double yp, double xk, double yk) {
            x = xk - xp;
            y = yk - yp;
        }

        public Wektor normalny() {
            double l = Math.sqrt(x * x + y * y);
            return new Wektor(x / l, y / l);
        }

        public Wektor prostopadly() {
            return new Wektor(-y, x);
        }

        public double iloczynSkalarny(Wektor w2) {
            return x * w2.x + y * w2.y;
        }

        public Wektor mnozPrzezSkalar(double s) {
            return new Wektor(s * x, s * y);
        }

        public Wektor dodaj(Wektor w2) {
            return new Wektor(x + w2.x, y + w2.y);
        }
    }
}

