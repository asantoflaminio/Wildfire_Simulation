package utils;

public class Forest <T>{
    private int width,height;

    private Cell[][] forest;

    public Forest(int width, int height){
        this.width = width;
        this.height = height;
        this.forest = new Cell[width][height];
        initializeForest();
    }

    private void initializeForest() {
        //inicializar como es la grilla inicial, en el modelo1 el T va a ser StateEnum mientras que en el modelo2 va a ser Double
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.forest[i][j] = new Cell<T>(i,j, null );
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Cell[][] getForest() {
        return forest;
    }

    public void setForest(Cell[][] forest) {
        this.forest = forest;
    }
}
