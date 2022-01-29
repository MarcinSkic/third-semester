package com.defaultcompany;

public class Main {

    public static void main(String[] args) {
	    Ship sh1 = new Ship();

        Ship sh2 = new Ship();
        sh2.setState(Ship.EMPTY);
        sh2.setName("U-Boat");
        sh2.setCapacity(2000);

        Ship sh3 = new Ship();
        sh3.setState(Ship.FULL);
        sh3.setName("HMS Hood");
        sh3.setCapacity(57000);

        Ship sh4 = new Ship();
        sh4.setState(Ship.EMPTY);
        sh4.setName("Bismarck");
        sh4.setCapacity(40000);

        sh3.ransack(sh4);
        sh4.ransack(sh3);
        sh2.ransack(sh1);
        System.out.println(sh1);
        System.out.println(sh2);
        System.out.println(sh3);
        System.out.println(sh4);

    }
}
