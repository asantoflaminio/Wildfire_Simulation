package utils;

import java.io.IOException;

public interface Simulation {

    void runSimulation() throws IOException;

    void saveState(Forest forest);

    void calculateFireEvolution();

    Double calculateState (Double previousState);
}
