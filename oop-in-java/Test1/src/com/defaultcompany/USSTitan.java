package com.defaultcompany;

import java.util.Arrays;

public class USSTitan extends Ship{
    private Cargo[] cargo;

    public USSTitan(String name, int capacity) {
        super.setName(name);
        super.setCapacity(capacity);
        super.setState(Ship.EMPTY);
    }

    public void setCargo(Cargo[] cargo){
        this.cargo = cargo;

        if(this.cargo == null){
            setState(Ship.EMPTY);
        } else {
            setState(Ship.FULL);
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                " and consists of cargo: " + Arrays.toString(cargo);
    }
}
