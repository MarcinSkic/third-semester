package com.skic;

public class Square extends Rectangle {
    public Square(int amountOfNodes, int amountOfSides, int a) {
        super(amountOfNodes, amountOfSides, a, a);
    }

    @Override
    protected void CalculateArea() {
        area = a*a;
    }

    @Override
    protected void CalculatePerimeter() {
        perimeter = a*4;
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
}
