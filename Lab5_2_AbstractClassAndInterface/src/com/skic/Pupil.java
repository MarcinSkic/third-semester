package com.skic;

public class Pupil extends Kid implements Basic, School{
    @Override
    public void fun() {
        System.out.println("Fun");
    }

    @Override
    public void chores() {
        System.out.println("Sprzatanko pokoiku");
    }

    @Override
    public void sleep() {
        System.out.println("Spanko");
    }

    @Override
    public void wakeUp() {
        System.out.println("Wstawanko");
    }

    @Override
    public void learn() {
        System.out.println("Nauka");
    }

    @Override
    public void doHomework() {
        System.out.println("Odrabianko");
    }

    @Override
    public void goToSchool() {
        System.out.println("Chodu chodu");
    }

    @Override
    public void comebackFromSchool() {
        System.out.println("Wracu wracu");
    }
}
