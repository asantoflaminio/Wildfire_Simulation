package model1;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {

        Double [] values = {0.40,0.45,0.50,0.55,0.60,0.65,0.70,0.75, 0.80,0.85};
        for (int j = 0; j < 10; j++) {
            for(int i = 1; i <=2; i++){
                SimulationImpl simulation = new SimulationImpl(values[j], i, false,1,0.1, "terrains/simpleSquare.txt",249,249, "generated_files/");
            }
        }

//        TerrainCreator.degradeTerrainElevation();
//        TerrainCreator.simpleSquare();
//        TerrainCreator.slopeSquare(100);
//        TerrainCreator.degradeTerrainDensity();
    }
}
