package com.skic;

public class Main {

    public static void main(String[] args) {
        Student student = new Student();
        System.out.println("Zycie studenta");
        student.wakeUp();
        student.eat();
        student.drinkingBeer();
        student.getNotes();
        student.study();
        student.getExcuse();
        student.wagary();
        student.sleep();

        System.out.println("\nZycie ucznia");
        Pupil pupil = new Pupil();
        pupil.eat();
        pupil.comebackFromSchool();
        pupil.doHomework();
        pupil.learn();
        pupil.fun();
        pupil.eat();
        pupil.sleep();

        System.out.println("\nZycie emeryta");
        Oldman oldman = new Oldman();
        oldman.wakeUp();
        oldman.dates();
        oldman.getRent();
        oldman.meaninglessTripToTown();
        oldman.nap();
        oldman.goToDoctor();
        oldman.hollidays();
        oldman.eat();
        oldman.drink();
        oldman.sleep();
    }
}
