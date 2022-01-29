package com.skic;

public class Polygon extends Shape{
    private int amountOfNodes;
    private int amountOfSides;
    private int sumOfAngles;

    public void CalculateSumOfInsideAngles(){
        sumOfAngles = (amountOfSides-2)*180;
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

    public void setAmountOfNodes(int amountOfNodes) {
        this.amountOfNodes = amountOfNodes;
    }

    public void setAmountOfSides(int amountOfSides) {
        this.amountOfSides = amountOfSides;
    }

    public void setSumOfAngles(int sumOfAngles) {
        this.sumOfAngles = sumOfAngles;
    }

    public int getAmountOfNodes() {
        return amountOfNodes;
    }

    public int getAmountOfSides() {
        return amountOfSides;
    }

    public int getSumOfAngles() {
        CalculateSumOfInsideAngles();
        return sumOfAngles;
    }

    public Polygon(int amountOfNodes, int amountOfSides) {
        super();
        this.amountOfNodes = amountOfNodes;
        this.amountOfSides = amountOfSides;
    }
}
