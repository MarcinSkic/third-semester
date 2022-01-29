package com.skic;

public abstract class Human {
    public int age;
    public String cechy[]  = {"Mily","Radosny","Inteligentny"};

    public abstract void eat();
    public abstract void drink();

    public int howOld(){
        return age;
    }

    public void showCechy(){
        for (var x: cechy) {
            System.out.println(x);
        }
    }
}
