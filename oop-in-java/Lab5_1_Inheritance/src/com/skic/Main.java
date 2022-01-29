package com.skic;

public class Main {

    public static void main(String[] args) {
        Square square = new Square(5,5,5);
        square.Draw();
        System.out.println(square.getArea());
        System.out.println(square.getPerimeter());

        Rectangle rectangle = new Rectangle(5,20,10,9);
        System.out.println(rectangle.getSumOfAngles());
    }
}
