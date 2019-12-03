package model1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SimulationImpl simulation = new SimulationImpl(1,0.1, "terrains/testTerrain.txt",1,1, "generated_files/");
        simulation.runSimulation();
    }
}