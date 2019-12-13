package model1;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        SimulationImpl simulation = new SimulationImpl(true,8000,20.0, "terrains/simpleSquare.txt",80,230, "generated_files/");
        simulation.runSimulation();
//        TerrainCreator.degradeTerrainElevation();
//        TerrainCreator.simpleSquare();
//        TerrainCreator.degradeTerrainDensity();
    }
}
