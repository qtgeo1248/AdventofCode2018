import java.util.*;
import java.io.*;

public class Day11a {
    public static int powerLevel(int x, int y, int serNum) {
        int power = (x + 10) * y + serNum;
        power *= (x + 10);
        power = (power % 1000) / 100;
        return power - 5;
    }
    public static void main(String[] args) {
        try {
            File f = new File("Day11SerialNum.txt");
            Scanner in = new Scanner(f);
            int serial = in.nextInt();
            int[][] fuelCells = new int[301][301];
            for (int i = 1; i < fuelCells.length; i++) {
                for (int j = 1; j < fuelCells[i].length; j++) {
                    fuelCells[i][j] = powerLevel(j, i, serial);
                }
            }

            int largestX = 1;
            int largestY = 1;
            int largestFuels = fuelCells[1][1] + fuelCells[1][2] + fuelCells[1][3] +
                                fuelCells[2][1] + fuelCells[2][2] + fuelCells[2][3] +
                                fuelCells[3][1] + fuelCells[3][2] + fuelCells[3][3];
            for (int i = 1; i < fuelCells.length - 2; i++) {
                for (int j = 1; j < fuelCells[i].length - 2; j++) {
                    int current = 0;
                    current += fuelCells[i][j];
                    current += fuelCells[i][j + 1];
                    current += fuelCells[i][j + 2];
                    current += fuelCells[i + 1][j];
                    current += fuelCells[i + 1][j + 1];
                    current += fuelCells[i + 1][j + 2];
                    current += fuelCells[i + 2][j];
                    current += fuelCells[i + 2][j + 1];
                    current += fuelCells[i + 2][j + 2];
                    if (current > largestFuels) {
                        largestFuels = current;
                        largestX = j;
                        largestY = i;
                    }
                }
            }
            System.out.println(largestX + ", " + largestY + ", " + largestFuels);

        } catch (FileNotFoundException e) {
        }
    }
}
