package com.defaultcompany;

public class SHIP {
    public SHIP(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    String name;
    int capacity; //In tones hehe

    @Override
    public String toString() {
        return "SHIP{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
