package model2;


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

        runSimulation();
    }

    @Override
    public void runSimulation() {

        for (int i = 0; i < totalTime; i += timeStep) {
            //calculateState
            //if new cell has been burnt, save state to be animated
        }
    }

    @Override
    public void saveState(Forest forest) {

    }

    @Override
    public void calculateFireEvolution() {

    }

    @Override
    public Double calculateState(Double state) {
        return 1d;
    }

}

