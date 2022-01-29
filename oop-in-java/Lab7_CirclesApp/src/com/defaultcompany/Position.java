package com.defaultcompany;

public class Position{
    int x, y, size;

    public Position(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    @Override
    public String toString() {
        return x+":"+y+":"+size;
    }
}
