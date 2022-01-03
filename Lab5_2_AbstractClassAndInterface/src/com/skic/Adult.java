package com.skic;

public abstract class Adult extends Human{
    @Override
    public void eat() {
        System.out.println("Spozywam");
    }

    @Override
    public void drink() {
        System.out.println("Nawadniam sie");
    }

    public abstract void hollidays();
    public abstract void dates();
}
