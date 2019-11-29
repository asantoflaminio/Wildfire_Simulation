package utils;

public class Cell<T> {
    private T state;
    private int x,y;

    public Cell(int x, int y, T initialState) {
        this.state = initialState;
        this.x = x;
        this.y = y;
    }

    public T getState(){
        return this.state;
    }

    public void setState(T state) {
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
