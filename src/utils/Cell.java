package utils;

public class Cell{
    private double state;
    private int x,y;
    private double ros;


    public Cell(int x, int y, double initialState) {
        this.state = initialState;
        this.x = x;
        this.y = y;
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
}
