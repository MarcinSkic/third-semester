package com.defaultcompany;

public class Ship {
    public static final int FULL = 1;
    public static final int EMPTY = 0;

    private String name;
    private int state;
    private int capacity;

    public Ship(String name, int state, int capacity) {
        this.name = name;
        this.state = state;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String toString(Formatter formatter){
        return formatter.format(this);
    }
}
