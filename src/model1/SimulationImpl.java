package model1;


import utils.Forest;
import utils.Simulation;

public class SimulationImpl implements Simulation {

    private long totalTime;
    private double timeStep;
    private Forest forest;

    SimulationImpl(long totalTime, int timeStep, int x, int fireStart){
        this.totalTime = totalTime;
        this.timeStep = timeStep;
        forest = new Forest(20,20);
        runSimulation();
    }

    @Override
    public void runSimulation() {

        for (int i = 0; i < totalTime; i += timeStep) {
            saveState(calculateState(forest));
        }
    }

    @Override
    public void saveState(Forest forest) {

    }

    @Override
    public Forest calculateState(Forest previousForest) {
        return null;
    }

}

