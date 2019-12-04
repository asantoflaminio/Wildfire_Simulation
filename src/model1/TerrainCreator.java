package model1;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TerrainCreator {

    /*
        700 width
        300 height
        De izquierda a derecha va teniendo tres partes, aumentando la densidad
     */
    public static void degradeTerrainDensity() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("terrains/densTerrain.txt", true));
        StringBuilder builder = new StringBuilder().append(700 + "\r\n").append(300 + "\r\n");

        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 300; j++) {
                builder.append(i + " " + j + " " + "2.0" + " " + "2" + " " + "1" + " " + "0.0" + " " + "1.0" + "\r\n");
            }
        }

        for(int i = 100; i < 300; i++) {
            for(int j = 0; j < 300; j++) {
                builder.append(i + " " + j + " " + "2.0" + " " + "2" + " " + "2" + " " + "0.0" + " " + "1.0" + "\r\n");
            }
        }

        for(int i = 300; i < 700; i++) {
            for(int j = 0; j < 300; j++) {
                builder.append(i + " " + j + " " + "2.0" + " " + "2" + " " + "3" + " " + "0.0" + " " + "1.0" + "\r\n");
            }
        }
        bw.write(builder.toString());
        bw.flush();
        bw.close();
        System.out.println("Terrain created.");
     }



    /*
       700 width
       300 height
       De izquierda a derecha va teniendo tres partes, disminuyendo la elevacion
    */
    public static void degradeTerrainElevation() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("terrains/elevTerrain.txt", true));
        StringBuilder builder = new StringBuilder().append(700 + "\r\n").append(300 + "\r\n");
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 300; j++) {
                builder.append(i + " " + j + " " + "2.0" + " " + "2" + " " + "3" + " " + "1505.0" + " " + "1.0" + "\r\n");
            }
        }

        for(int i = 100; i < 300; i++) {
            for(int j = 0; j < 300; j++) {
                builder.append(i + " " + j + " " + "2.0" + " " + "2" + " " + "3" + " " + "1002.0" + " " + "1.0" + "\r\n");
            }
        }

        for(int i = 300; i < 700; i++) {
            for(int j = 0; j < 300; j++) {
                builder.append(i + " " + j + " " + "2.0" + " " + "2" + " " + "3" + " " + "400.0" + " " + "1.0" + "\r\n");
            }
        }
        bw.write(builder.toString());
        bw.flush();
        bw.close();
        System.out.println("Terrain created.");
    }
}
