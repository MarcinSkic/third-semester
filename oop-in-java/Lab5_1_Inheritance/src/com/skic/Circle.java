package com.skic;

public class Circle extends Ellipse{
public int r;

    public Circle(int a, int b, int f1x, int f1y, int f2x, int f2y, int c, int r) {
        super(a, b, f1x, f1y, f2x, f2y, c);
        this.r = r;
    }

    @Override
    protected void CalculateArea() {
        area = (int) (Math.PI*Math.pow(r,2));
    }

    @Override
    protected void CalculatePerimeter() {
        perimeter = (int)Math.PI*2*r;
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

    public void setR(int r) {
        this.r = r;
    }

    public int getR() {
        return r;
    }
}
