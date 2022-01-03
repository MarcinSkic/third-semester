package com.defaultcompany;

public class Pancake {
    public State state = State.Raw;
    public int number;

    public Pancake(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Pancake{" +
                "state=" + state.name() +
                ", number=" + number +
                '}';
    }
}
