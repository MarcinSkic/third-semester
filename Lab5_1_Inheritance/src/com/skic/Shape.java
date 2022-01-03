package com.skic;

import java.awt.*;

public class Shape {
    protected int area;
    protected int perimeter;
    private Color kolor;

    Shape( ){
        kolor = Color.GREEN;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setPerimeter(int perimeter) {
        this.perimeter = perimeter;
    }

    public void setKolor(Color kolor) {
        this.kolor = kolor;
    }

    public int getArea() {
        CalculateArea();
        return area;
    }

    public int getPerimeter() {
        CalculatePerimeter();
        return perimeter;
    }

    public Color getKolor() {
        return kolor;
    }

    protected void Draw(){
        System.out.println("Trwa rysowanie figury");
    }

    protected void Delete(){
        System.out.println("Trwa usuwanie figury");
    }

    protected void Move() {
        System.out.println("Trwa przesuwanie figury");
    }

    protected  void CalculateArea(){

    }

    protected  void CalculatePerimeter(){

    }

    protected String giveParameters(){
        return "Kolor: "+ kolor.toString() + " Powierzchnia: " + area +  " Obwod: ";
    }
}
