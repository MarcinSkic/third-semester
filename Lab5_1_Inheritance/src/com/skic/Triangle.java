package com.skic;

public class Triangle extends Polygon{
    int h, a,b,c;

    public Triangle(int amountOfNodes, int amountOfSides, int h, int a, int b, int c) {
        super(amountOfNodes, amountOfSides);
        this.h = h;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    protected void CalculateArea() {
        area = a*h/2;
    }

    @Override
    protected void CalculatePerimeter() {
        perimeter = a+b+c;
    }

    @Override
    protected void Draw() {
        super.Draw();
    }

    @Override
    protected void Delete() {
        super.Delete();
    }

    @Override
    protected void Move() {
        super.Move();
    }

    @Override
    protected String giveParameters() {
        return super.giveParameters();
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
