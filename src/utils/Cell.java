package utils;

import model1.StateEnum;

public class Cell{
    private double state;
    private int x,y;
    private double ros;
    private double vegetation;
    private double density;
    private double elevation;
    private double squareLength;
    private boolean spreadInto;


    public Cell(int x, int y, double initialState, double vegetation, double density, double elevation, double squareLength) {
        this.state = initialState;
        this.x = x;
        this.y = y;
        this.vegetation = vegetation;
        this.density = density;
        this.elevation = elevation;
        this.squareLength = squareLength;
    }

    public double getSquareLength() {
        return squareLength;
    }

    public void setSquareLength(double squareLength) {
        this.squareLength = squareLength;
    }

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public double getState(){
        return this.state;
    }

    public void setState(double state) {
        this.state = state;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getRos() {
        return ros;
    }

    public void setRos(double ros) {
        this.ros = ros;
    }

    public double getVegetation() {
        return vegetation;
    }

    public void setVegetation(double vegetation) {
        this.vegetation = vegetation;
    }

    @Override
    public String toString() {
        return "[" +
                "s=" + state +
//                ", x=" + x +
//                ", y=" + y +
//                ", v=" + vegetation +
                ']';
    }

    public void setSpreadInto(boolean spreadInto) {
        this.spreadInto = spreadInto;
    }

    public boolean isSpreadInto() {
        return spreadInto;
    }
}
