package com.defaultcompany;

public class Cargo {

    public Cargo(String cargoType, int amount) {
        this.cargoType = cargoType;
        this.amount = amount;
    }

    public String cargoType;
    public int amount;

    @Override
    public String toString() {
        return "Cargo{" +
                "cargoType='" + cargoType + '\'' +
                ", amount=" + amount +
                '}';
    }
}
