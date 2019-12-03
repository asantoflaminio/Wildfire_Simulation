package model1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SimulationImpl simulation = new SimulationImpl(1,0.1, 200,200,50,50, "generated_files/");
        simulation.runSimulation();
    }
}