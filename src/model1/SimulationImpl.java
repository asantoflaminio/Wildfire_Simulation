package model1;


import utils.Cell;
import utils.Forest;
import utils.Simulation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class SimulationImpl implements Simulation {

    private long totalTime;
    private double timeStep;
    private Forest forest;
    /*
    Usemos siempre celdas de 1x1 porque sino tenemos que cambiar el tema
    de initializeForest etc.
     */
    private static double SQUARE_LENGTH = 1.0; // vamos a tener celdas de 1mx1m
    FileManager fm;

    /* Variables */
    private static double Ph = 0.58;// probability constant
    private static double a = 0.078;
    private static double c1 = 0.045;
    private static double c2 = 0.131;
    private double windSpeed = 10; // m/s
    private WindEnum windDirection = WindEnum.NORTH;


    SimulationImpl(long totalTime, double timeStep, int fireStartX, int fireStartY, String filepath) {
        this.totalTime = totalTime;
        this.timeStep = timeStep;
        this.forest = initializeForest(5,5);
        this.forest.getCell(fireStartX,fireStartY).setState(3);
        fm = new FileManager(filepath);
        printForest();
    }

    private Forest initializeForest(int width, int height) {
        Forest forest = new Forest(width, height);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Cell cell = new Cell(i, j, 2d, 1, 0.5, 0, SQUARE_LENGTH);
                forest.getForest()[i][j] = cell;
            }
        }
        return forest;
    }
    private Forest copyForest(Forest previousForest) {
        Forest forest = new Forest(previousForest.getWidth(), previousForest.getHeight());
        for (int i = 0; i < previousForest.getWidth(); i++) {
            for (int j = 0; j < previousForest.getHeight(); j++) {
                Cell cell = new Cell(i, j, previousForest.getCell(i,j).getState(), previousForest.getCell(i,j).getVegetation(), previousForest.getCell(i,j).getDensity(),
                        previousForest.getCell(i,j).getElevation(), SQUARE_LENGTH);
                forest.getForest()[i][j] = cell;
            }
        }
        return forest;
    }
    @Override
    public void runSimulation() throws IOException {


//        for (double i = 0; i < totalTime; i += timeStep) {
//            calculateFireEvolution();
//            System.out.println("---------------------- Forest at time: "+i+" ----------------------");
//            printForest();
//            //if new cell has been burnt, save state to be animated
//        }
        fm.printForestForAnimation(this.forest);
        fm.close();
    }

    @Override
    public void saveState(Forest forest) {

    }

    @Override
    public void calculateFireEvolution() {
        Forest newForest = copyForest(this.forest);
        int width = this.forest.getWidth();
        int height = this.forest.getHeight();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Cell current = this.forest.getCell(i,j);
                //Uso la variable spreadInto para que no se reescriba lo de neighbours
                if(!current.isSpreadInto()) {
                    double currentState = current.getState();
                    if (currentState == 3) {
                        newForest.getCell(i, j).setState(4D);
                        //TODO ver de sacar pero que se modifique bien (al llamar a un metodo se pasa una copia)
                        ArrayList<Cell> neighbours = new ArrayList<>();
                        //  | i-1, j-1 | i, j-1 | i+1, j-1 |
                        //  | i-1, j   | i, j   | i+1, j   |
                        //  | i-1, j+1 | i, j+1 | i+1, j+1 |
                        if(i-1 >= 0 && j-1 >= 0)        neighbours.add(this.forest.getCell(i-1,j-1));
                        if(j-1 >= 0)                    neighbours.add(this.forest.getCell(i,j-1));
                        if(i+1 < width && j-1 >= 0)     neighbours.add(this.forest.getCell(i+1,j-1));
                        if(i-1 >= 0)                    neighbours.add(this.forest.getCell(i-1,j));
                        if(i+1 < width)                 neighbours.add(this.forest.getCell(i+1,j));
                        if(i-1 >= 0 && j+1 < height)    neighbours.add(this.forest.getCell(i-1,j+1));
                        if(j+1 < height)                neighbours.add(this.forest.getCell(i,j+1));
                        if(i+1 < width && j+1 < height) neighbours.add(this.forest.getCell(i+1,j+1));

                        for (Cell c: neighbours) {
                            Cell n = newForest.getCell(c.getX(), c.getY());
                            if( Math.random() < 0.78 && n.getState() != 4d && n.getState() != 1d) { //TODO pburn
                                n.setState(3d);
                            }
                            this.forest.getCell(c.getX(), c.getY()).setSpreadInto(true);
                        }
                    }
                    else {
                        newForest.getCell(i, j).setState(currentState);
                    }
                }
            }
        }

        this.forest = newForest;
        clearForest();
    }

    private void clearForest() {
        for (int i = 0; i < this.forest.getHeight(); i++) {
            for (int j = 0; j < this.forest.getWidth(); j++) {
                this.forest.getCell(i,j).setSpreadInto(false);
            }
        }
    }

    private void calculateStatesForNeighbours(int x, int y, Forest newForest) {
//        ArrayList<Cell> neighbours = new ArrayList<>();
//        //  | x-1, y-1 | x, y-1 | x+1, y-1 |
//        //  | x-1, y   | x, y   | x+1, y   |
//        //  | x-1, y+1 | x, y+1 | x+1, y+1 |
//
//        neighbours.add(this.forest.getCell(x-1,y-1));
//        neighbours.add(this.forest.getCell(x,y-1));
//        neighbours.add(this.forest.getCell(x+1,y-1));
//        neighbours.add(this.forest.getCell(x-1,y));
//        neighbours.add(this.forest.getCell(x+1,y));
//        neighbours.add(this.forest.getCell(x-1,y+1));
//        neighbours.add(this.forest.getCell(x,y+1));
//        neighbours.add(this.forest.getCell(x+1,y+1));
//
//        for (Cell c: neighbours) {
//            int cellX = c.getX();
//            int cellY = c.getY();
//            if(cellX >= 0 && cellY >= 0 && cellX < this.forest.getWidth() && cellY < this.forest.getHeight()) {
//                if( Math.random() < 0.78) { //TODO pburn
//                    Cell n = newForest.getCell(cellX, cellY);
//                    n.setState(3d);
//                    n.setSpreadInto(true);
//                }
//            }
//        }
    }

    private void printForest() {
        for (int i = 0; i < this.forest.getHeight(); i++) {
            for (int j = 0; j < this.forest.getWidth(); j++) {
                System.out.print(this.forest.getCell(j,i)+" ");
            }
            System.out.println();
        }
    }

    private double calculatePBurn(Cell evaluatedCell, Cell burningCell) {

        double Pw = calculatePWind(evaluatedCell, burningCell);
        double Ps = calculatePSlope(evaluatedCell, burningCell);
        return Ph * (1 + evaluatedCell.getVegetation()) * (1 + evaluatedCell.getDensity()) * Pw * Ps;

    }

    private double calculatePWind() {

        double angle;
        if(windDirection.equals(WindEnum.NORTH)) {
            angle = getWindAngle();
        }

        double ft = Math.exp(windSpeed*c2*(Math.cos(Math.toRadians(angle)) - 1));
        return Math.exp(c1*windSpeed)*ft;
    }

    private double calculatePSlope(Cell evaluatedCell, Cell burningCell) {


        double angle;
            /*
            Case 1: Adjacent
             */
            if((evaluatedCell.getX() == burningCell.getX()) && (evaluatedCell.getY() == burningCell.getY())) {
               angle = Math.atan((evaluatedCell.getElevation() - burningCell.getElevation())/SQUARE_LENGTH);
            } else {
            /*
            Case 2: Diagonal
             */
                angle = Math.atan((evaluatedCell.getElevation() - burningCell.getElevation())/(Math.sqrt(2)*SQUARE_LENGTH));
            }

        return Math.exp(a*angle);
    }
}

