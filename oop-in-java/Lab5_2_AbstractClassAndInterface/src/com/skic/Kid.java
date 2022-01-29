package com.skic;

public abstract class Kid extends Human{

    @Override
    public void eat() {
        System.out.println("Zrem");
    }

    @Override
    public void drink() {
        System.out.println("Pijem");
    }

    public abstract void fun();
    public abstract void chores();
}
