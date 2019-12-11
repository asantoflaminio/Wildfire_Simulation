package model1;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        SimulationImpl simulation = new SimulationImpl(1,0.1, "terrains/densTerrain.txt",80,230, "generated_files/");
        simulation.runSimulation();
//        TerrainCreator.degradeTerrainElevation();
//        TerrainCreator.degradeTerrainDensity();
    }
}
