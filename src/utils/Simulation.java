package utils;

public interface Simulation {

    void runSimulation();

    void saveState(Forest forest);

    void calculateFireEvolution();

    Double calculateState (Double previousState);
}
