package utils;

import model1.StateEnum;

public class Cell{
    private double state;
    private int x,y;
    private double ros;
    private int vegetation;
    private int density;
    private double elevation;
    private double squareLength;
    private boolean spreadInto;


    public Cell(int x, int y, double initialState, int vegetation, int density, double elevation, double squareLength) {
        this.state = initialState;
        this.x = x;
        this.y = y;
        this.vegetation = vegetation;
        this.density = density;
        this.elevation = elevation;
        this.squareLength = squareLength;
        this.spreadInto = false;
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

    public int getDensity() {
        return density;
    }

    public double getPDen() {
        switch (density) {
            case 1:
                return -0.4;
            case 2:
                return 0;
            case 3:
                return 0.3;
        }
        return -0.4;
    }

    public void setDensity(int density) {
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

    public int getVegetation() {
        return vegetation;
    }

    public void setVegetation(int vegetation) {
        this.vegetation = vegetation;
    }

    public double getPVeg() {
        switch (vegetation) {
            case 1:
                return -0.3;
            case 2:
                return 0;
            case 3:
                return 0.4;

        }
        return 0;
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
