package model1;


import utils.Cell;
import utils.Forest;
import utils.Simulation;

public class SimulationImpl implements Simulation {

    private long totalTime;
    private double timeStep;
    private Forest forest;

    SimulationImpl(long totalTime, int timeStep, int x, int fireStart){
        this.totalTime = totalTime;
        this.timeStep = timeStep;
        this.forest = new Forest(20,20);
        //for each cell in forest
            // calculateRos
            // calculateWindSpeedMatrix
            // calculateHeightMatrix
            //initializeCell with those variables

        runSimulation();
    }

    @Override
    public void runSimulation() {

        for (int i = 0; i < totalTime; i += timeStep) {
            calculateFireEvolution();
            //if new cell has been burnt, save state to be animated
        }
    }

    @Override
    public void saveState(Forest forest) {

    }

    @Override
    public void calculateFireEvolution() {
        Forest newForest = new Forest(this.forest.getWidth(), this.forest.getHeight()); //TODO duplicate previousForest
        for (int i = 0; i < this.forest.getWidth(); i++) {
            for (int j = 0; j < this.forest.getHeight(); j++) {
                newForest.getCell(i,j).setState(calculateState(this.forest.getCell(i,j).getState()));
            }
        }
    }

    @Override
    public Double calculateState(Double previousState) {
        switch (previousState.intValue()) {
            case 1:
                return 1D;
            case 2:

                break;
            case 3:
                //ripperoni pepperoni
                break;
            case 4:
                break;
        }
        return 1d; //TODO
    }

}

