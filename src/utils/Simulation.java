package utils;

public interface Simulation {

    void runSimulation();

    void saveState(Forest forest);

    Forest calculateState(Forest previousForest);
}
