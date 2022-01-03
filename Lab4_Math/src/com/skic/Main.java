package com.skic;

public class Main {

    public static void main(String[] args) {
        DoExThree();
    }
    public static void DoExOne(){
        ExerciseOne exerciseOne = new ExerciseOne();
        exerciseOne.show1DArray(exerciseOne.fillAray());
    }
    public static void DoExTwo(){
        ExerciseTwo exerciseTwo = new ExerciseTwo();
        var array = exerciseTwo.fill2DArray();
        exerciseTwo.showArray(array);
        exerciseTwo.checkDifferenceBetweenSums(array);
    }
    public static void DoExThree(){
        ExerciseThree exerciseThree = new ExerciseThree();
        var circles = exerciseThree.CreateCircles();
        exerciseThree.ShowCircles(circles);
        exerciseThree.CheckCircles(new Circle(5,5,2),new Circle(5,5,2));
    }

}
