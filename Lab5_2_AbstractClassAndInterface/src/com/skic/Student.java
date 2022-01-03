package com.skic;

public class Student extends Adult implements Basic, College, Work{

    @Override
    public void hollidays() {
        System.out.println("Wakacje 3 miesiace");
    }

    @Override
    public void dates() {
        System.out.println("Kluby itd");
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
    public void study() {
        System.out.println("Potezna nauka");
    }

    @Override
    public void wagary() {
        System.out.println("Uciekne sobie");
    }

    @Override
    public void drinkingBeer() {
        System.out.println("Kazik");
    }

    @Override
    public void getNotes() {
        System.out.println("No daj notatki");
    }

    @Override
    public void work() {
        System.out.println("Pracu");
    }

    @Override
    public void taxes() {
        System.out.println("Jeszcze nic podatki");
    }

    @Override
    public void sendEmails() {
        System.out.println("Szefie zrobilem to zadanie");
    }

    @Override
    public void getExcuse() {
        System.out.println("Dzisiaj nie moge przyjsc bo mam kolokwium jutro");
    }
}
