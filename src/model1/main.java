package model1;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        double[] densities = {-0.5, -0.4, -0.3, -0.2, -0.1, 0, 0.1, 0.2, 0.3, 0.4, 0.5};
        for (int i = 0; i < densities.length; i++) {
            SimulationImpl simulation = new SimulationImpl(1,0.1, "terrains/simpleSquare.txt",
                    249,249, "generated_files/", densities[i]);
            simulation.runSimulation();
        }
//        TerrainCreator.degradeTerrainElevation();
//        TerrainCreator.simpleSquare();
//        TerrainCreator.degradeTerrainDensity();
    }
}
