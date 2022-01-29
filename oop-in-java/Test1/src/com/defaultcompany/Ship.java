package com.defaultcompany;

public class Ship {
    public static final int FULL = 1;
    public static final int EMPTY = 0;

    protected String name;
    protected int state;
    protected int capacity;

    public Ship() {
        this.name = "USS Luizjana";
        this.state = Ship.FULL;
        this.capacity = 20000;
    }

    public void ransack(Ship cargoShip){
        if(cargoShip.getState()==Ship.FULL && state == Ship.EMPTY){
            System.out.println(name + " has ransacked " + cargoShip.getName());
            cargoShip.setState(Ship.EMPTY);
            state = Ship.FULL;
        }
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

    @Override
    public String toString() {
        return "This is ship "+name+" which state is "+state+" and has capacity of "+capacity+"t";
    }
}
