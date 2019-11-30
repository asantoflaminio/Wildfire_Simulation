package model1;


import utils.Cell;
import utils.Forest;
import utils.Simulation;

import java.util.ArrayList;
import java.util.Random;

public class SimulationImpl implements Simulation {

    private long totalTime;
    private double timeStep;
    private Forest forest;

    SimulationImpl(long totalTime, double timeStep, int fireStartX, int fireStartY){
        this.totalTime = totalTime;
        this.timeStep = timeStep;
        this.forest = initializeForest(5,5);
        this.forest.getCell(fireStartX,fireStartY).setState(3);
        printForest();
    }

    private Forest initializeForest(int width, int height) {
        Forest forest = new Forest(width, height);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Cell cell = new Cell(i, j, 2d, 1);
                forest.getForest()[i][j] = cell;
            }
        }
        return forest;
    }
    private Forest copyForest(Forest previousForest) {
        Forest forest = new Forest(previousForest.getWidth(), previousForest.getHeight());
        for (int i = 0; i < previousForest.getWidth(); i++) {
            for (int j = 0; j < previousForest.getHeight(); j++) {
                Cell cell = new Cell(i, j, previousForest.getCell(i,j).getState(), previousForest.getCell(i,j).getVegetation());
                forest.getForest()[i][j] = cell;
            }
        }
        return forest;
    }
    @Override
    public void runSimulation() {

        for (double i = 0; i < totalTime; i += timeStep) {
            calculateFireEvolution();
            System.out.println("---------------------- Forest at time: "+i+" ----------------------");
            printForest();
            //if new cell has been burnt, save state to be animated
        }
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
                if(!current.isSpreadInto()) {
                    double currentState = current.getState();
                    if (currentState == 3) {
                        newForest.getCell(i, j).setState(4D);
                        ArrayList<Cell> neighbours = new ArrayList<>();
                        //  | x-1, y-1 | x, y-1 | x+1, y-1 |
                        //  | x-1, y   | x, y   | x+1, y   |
                        //  | x-1, y+1 | x, y+1 | x+1, y+1 |
                        if(i-1 >= 0 && j-1 >= 0)        neighbours.add(this.forest.getCell(i-1,j-1));
                        if(j-1 >= 0)                    neighbours.add(this.forest.getCell(i,j-1));
                        if(i+1 < width && j-1 >= 0)     neighbours.add(this.forest.getCell(i+1,j-1));
                        if(i-1 >= 0)                    neighbours.add(this.forest.getCell(i-1,j));
                        if(i+1 < width)                 neighbours.add(this.forest.getCell(i+1,j));
                        if(i-1 >= 0 && j+1 < height)    neighbours.add(this.forest.getCell(i-1,j+1));
                        if(j+1 < height)                neighbours.add(this.forest.getCell(i,j+1));
                        if(i+1 < width && j+1 < height) neighbours.add(this.forest.getCell(i+1,j+1));

                        for (Cell c: neighbours) {
                            int cellX = c.getX();
                            int cellY = c.getY();
                            if( Math.random() < 0.78) { //TODO pburn
                                Cell n = newForest.getCell(cellX, cellY);
                                n.setState(3d);
                                n.setSpreadInto(true);
                            }
                        }
                    }
                    else {
                        newForest.getCell(i, j).setState(currentState);
                    }
                }
            }
        }
        clearForest();
        this.forest = newForest;
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

    @Override
    public Double calculateState(Double previousState) {

        return 1d; //TODO
    }

    private void printForest() {
        for (int i = 0; i < this.forest.getHeight(); i++) {
            for (int j = 0; j < this.forest.getWidth(); j++) {
                System.out.print(this.forest.getCell(j,i)+" ");
            }
            System.out.println();
        }
    }
}

