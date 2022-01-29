package com.skic;

class Ellipse extends Shape {
    private int a, b, F1x, F1y, F2x, F2y, c;

    public void calculateDistanceToMiddle(){
        c = (int) Math.sqrt(Math.pow(a,2)-Math.pow(b,2));
    }

    @Override
    protected void CalculateArea() {

    }

    @Override
    protected void CalculatePerimeter() {

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

    public void setF1x(int f1x) {
        F1x = f1x;
    }

    public void setF1y(int f1y) {
        F1y = f1y;
    }

    public void setF2x(int f2x) {
        F2x = f2x;
    }

    public void setF2y(int f2y) {
        F2y = f2y;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getF1x() {
        return F1x;
    }

    public int getF1y() {
        return F1y;
    }

    public int getF2x() {
        return F2x;
    }

    public int getF2y() {
        return F2y;
    }

    public int getC() {
        return c;
    }

    public Ellipse(int a, int b, int f1x, int f1y, int f2x, int f2y, int c){
        super();
        this.a = a;
        this.b = b;
        F1x = f1x;
        F1y = f1y;
        F2x = f2x;
        F2y = f2y;
        this.c = c;
    }
}
