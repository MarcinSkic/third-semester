package com.defaultcompany;

public class Ship {
    public static final int UZBROJONY = 1;
    public static final int NIEUZBROJONY = 1000;

    private String name;
    private int amountOfWeapons;
    private int weaponsState;

    public String toString(Formatujacy formatujacy) {
        return formatujacy.formatuj(this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmountOfWeapons(int amountOfWeapons) {
        this.amountOfWeapons = amountOfWeapons;
    }

    public void setWeaponsState(int weaponsState) {
        this.weaponsState = weaponsState;
    }

    public String getName() {
        return name;
    }

    public int getAmountOfWeapons() {
        return amountOfWeapons;
    }

    public int getWeaponsState() {
        return weaponsState;
    }

    public Ship(String name, int amountOfWeapons, int weaponsState) {
        this.name = name;
        this.amountOfWeapons = amountOfWeapons;
        this.weaponsState = weaponsState;
    }
}
