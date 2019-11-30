package model1;

import utils.Cell;
import utils.Forest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    BufferedWriter bwDensity;
    BufferedWriter bwElevation;

    public FileManager(String path) {
        try {
            bwDensity = new BufferedWriter(new FileWriter(path + "ForestFire_Density.txt", false));
            bwDensity = new BufferedWriter(new FileWriter(path + "ForestFire_Density.txt", true));
            bwElevation = new BufferedWriter(new FileWriter(path + "ForestFire_Elevation.txt", false));
            bwElevation = new BufferedWriter(new FileWriter(path + "ForestFire_Elevation.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printForestForAnimation(Forest forest) throws IOException {
        printForestByOption(forest, "density");
        printForestByOption(forest, "elevation");
    }

    /*
        Prints forest to a txt file in order to be read by Ovito.

        If option == density
        Color coding:
                      - Black: Burned down cell
                      - Red: Burning cell
                      - Green: Forest fuel cell with no fire. Green intensity varies according to density.
                      - Light blue: No fuel cell (waterways).


         If option == elevation
         Color coding:
                      - Black: Burned down cell
                      - Red: Burning cell
                      - Green: Forest fuel cell with no fire and elevation < x.
                      - Brown: Forest fuel with no fire and elevation > x. Brown intensity varies according
                      to cell elevation.
                      - Light blue: No fuel cell (waterways).

        Use square shape in Ovito!
     */
    private void printForestByOption(Forest forest, String option) throws IOException {
        int cellAmount = forest.getHeight() * forest.getWidth();
        StringBuilder builder = new StringBuilder().append(cellAmount + "\r\n").append("//ID\t X\t Y\t Radius\t R\t G\t B\r\n");
        for(int i = 0; i < forest.getHeight(); i++)  {
            for(int j = 0; j < forest.getWidth(); j++) {
                Cell current = forest.getCell(i, j);
                double id = Math.pow(2, i) * Math.pow(3, j);
                double state = current.getState();
                int rColor = 0;
                int gColor = 0;
                int bColor = 0;
                if(Double.compare(state, 1d) == 0) {
                    // 1d --> Cannot be burned: Waterways for example --> Light blue
                    rColor = 36;
                    gColor = 255;
                    bColor = 234;
                } else if (Double.compare(state, 2d) == 0) {
                    // 2d --> Forest fuel --> Green (intensity varies according to density)

                    if(option.equals("elevation")) {
                        /*
                        0 - 500m: green
                        500 - 1000m: yellow
                        1000 - 1500m: kinda brown
                        more than 1500m: brown
                         */
                        if(current.getElevation() < 500) {
                            rColor = 143;
                            gColor = 247;
                            bColor = 122;
                        } else if (current.getElevation() < 1000) {
                            rColor = 255;
                            gColor = 242;
                            bColor = 119;
                        } else if (current.getElevation() < 1500) {
                            rColor = 255;
                            gColor = 215;
                            bColor = 119;
                        } else {
                            rColor = 98;
                            gColor = 74;
                            bColor = 18;
                        }
                    } else {
                        //density is the default option
                        if(current.getDensity() < -0.1) {
                            //sparse
                            rColor = 130;
                            gColor = 235;
                            bColor = 141;
                        } else if ( current.getDensity() > 0.1) {
                            //dense
                            rColor = 0;
                            gColor = 107;
                            bColor = 11;
                        } else {
                            // normal (between -0.1 and 0.1)
                            rColor = 0;
                            gColor = 182;
                            bColor = 18;
                        }
                    }


                } else if (Double.compare(state, 3d) == 0) {
                    // 3d --> Burning down --> Red
                    rColor = 255;
                }

                // else
                // 4d --> Burned down --> Black (0,0,0)

                builder.append(id)
                        .append(" ")
                        .append(current.getX())
                        .append(" ")
                        .append(current.getY())
                        .append(" ")
                        .append(current.getSquareLength()/2)
                        .append(" ")
                        .append(rColor)
                        .append(" ")
                        .append(gColor)
                        .append(" ")
                        .append(bColor)
                        .append("\r\n");
            }
        }
        if(option.equals("elevation")) {
            bwElevation.write(builder.toString());
        } else{
            System.out.println(builder.toString());
            bwDensity.write(builder.toString());
        }
    }

    public void close() {
        if (bwDensity != null) try {
            bwDensity.flush();
            bwDensity.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        if (bwElevation != null) try {
            bwElevation.flush();
            bwElevation.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
