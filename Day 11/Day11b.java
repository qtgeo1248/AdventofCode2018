import java.util.*;
import java.io.*;

public class Day11b {
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
            int largestSize = 1;
            int largestFuels = fuelCells[1][1];
            for (int n = 1; n < 301; n++) {
                for (int i = 1; i < fuelCells.length - n + 1; i++) {
                    for (int j = 1; j < fuelCells[i].length - n + 1; j++) {
                        int current = 0;
                        for (int idx = i; idx < i + n - 1; idx++) {
                            for (int jdx = j; jdx < j + n - 1; jdx++) {
                                current += fuelCells[idx][jdx];
                            }
                        }
                        if (current > largestFuels) {
                            largestFuels = current;
                            largestX = j;
                            largestY = i;
                            largestSize = n;
                        }
                    }
                }
            }
            System.out.println(largestX + ", " + largestY + ", " + largestSize + ", " + largestFuels);

        } catch (FileNotFoundException e) {
        }
    }
}
