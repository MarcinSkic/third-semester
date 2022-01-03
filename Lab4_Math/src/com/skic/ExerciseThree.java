package com.skic;

public class ExerciseThree {
    public Circle[] CreateCircles(){
        Circle[] circles = new Circle[5];
        for(int i = 0; i < circles.length;i++){
            circles[i] = new Circle();
        }
        return circles;
    }

    public void ShowCircles(Circle[] circles){
        for (var item:circles) {
            System.out.println("x="+item.x+"y="+item.y+"r="+item.r);
        }
    }

    public void CheckCircles(Circle c1, Circle c2){
        if(c1.x == c2.x && c1.y == c2.y && c1.r == c2.r){
            System.out.println("Pokrywaja sie");
            return;
        }
        var distance = Math.sqrt(Math.pow(c2.x-c1.x,2)+Math.pow(c2.y-c1.y,2));
        if(distance > c1.r+c2.r){
            System.out.println("Rozlaczne");
        } else if(distance < c1.r+c2.r){
            System.out.println("Przecinajace");
        } else {
            System.out.println("Styczne");
        }
    }
}
