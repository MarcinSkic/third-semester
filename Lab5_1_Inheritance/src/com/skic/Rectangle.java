package com.skic;

public class Rectangle extends Polygon{
    int a,b;

    @Override
    protected void CalculateArea() {
        area = a*b;
    }

    @Override
    protected void CalculatePerimeter() {
        perimeter = (a+b)*2;
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

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public Rectangle(int amountOfNodes, int amountOfSides, int a, int b) {
        super(amountOfNodes, amountOfSides);
        this.a = a;
        this.b = b;
    }
}
