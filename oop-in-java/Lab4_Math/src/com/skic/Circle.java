package com.skic;

import java.util.Random;

public class Circle {
    public int x;
    public int y;
    public int r;

    public Circle(){
        Random random = new Random();
        x = random.nextInt(91)+5;
        y = random.nextInt(91)+5;
        r = random.nextInt(5)+1;
    }
    public Circle(int x, int y, int r){
        this.x = x;
        this.y = y;
        this.r = r;
    }


}
