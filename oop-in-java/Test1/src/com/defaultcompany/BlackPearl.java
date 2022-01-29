package com.defaultcompany;

import java.util.ArrayList;
import java.util.Arrays;

public class BlackPearl extends Ship implements Pirate{
    private ArrayList<Cargo> cargo = new ArrayList<Cargo>();

    public BlackPearl(String name, int capacity) {
        super.setName(name);
        super.setCapacity(capacity);
        super.setState(Ship.EMPTY);
    }

    public void setCargo(Cargo[] cargo) throws Exception {
        int providedCapacity = 0;
        for(var c : cargo){
            providedCapacity += c.amount;
            if(providedCapacity > super.getCapacity()){
                setState(Ship.FULL);
                throw new Exception("There is more cargo than capacity, interrupting loading");
            }
            this.cargo.add(c);
        }
        if(this.cargo == null){
            setState(Ship.EMPTY);
        } else {
            setState(Ship.FULL);
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                " and consists of cargo: " + cargo.toString();
    }

    @Override
    public void ransack(Ship cargoShip) {
        if(cargoShip.getState()==Ship.FULL && state == Ship.EMPTY){
            System.out.println(name + " has ransacked " + cargoShip.getName());
            cargoShip.setState(Ship.EMPTY);
            state = Ship.FULL;
        }
    }
}
