package utils;

public class Cell{
    private double state;
    private int x,y;
    private double ros;
    private int vegetation;
    private boolean spreadInto;


    public Cell(int x, int y, double initialState, int vegetation) {
        this.state = initialState;
        this.x = x;
        this.y = y;
        this.vegetation = vegetation;
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
