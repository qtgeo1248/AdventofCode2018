import java.util.*;
import java.io.*;

public class Day6a {
    public static void main(String[] args) {
        try {
            File f = new File("Day6Coords.txt");
            Scanner in = new Scanner(f);
            Point[] points = new Point[50]; //change when testing to 50
            for (int idx = 0; in.hasNext(); idx++) {
                String line = in.nextLine();
                int x = Integer.parseInt(line.substring(0, line.indexOf(",")));
                int y = Integer.parseInt(line.substring(line.indexOf(",") + 2));
                points[idx] = new Point(x, y);
            }

            Point[][] grid = new Point[500][500]; //change to 1000,1000
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    grid[i][j] = new Point(i, j);
                }
            }

            int[][] closestVals = new int[500][500]; // change to 1000, 1000
            for (int i = 0; i < closestVals.length; i++) {
                for (int j = 0; j < closestVals[i].length; j++) {
                    closestVals[i][j] = grid[i][j].minDist(points);
                }
            }

            ArrayList<Integer> forbidden = new ArrayList<Integer>();
            for (int i = 0; i < closestVals.length; i++) {
                if (!forbidden.contains(closestVals[i][0])) {
                    forbidden.add(closestVals[i][0]);
                }
                if (!forbidden.contains(closestVals[i][closestVals[i].length - 1])) {
                    forbidden.add(closestVals[i][closestVals[i].length - 1]);
                }
                if (!forbidden.contains(closestVals[0][i])) {
                    forbidden.add(closestVals[0][i]);
                }
                if (!forbidden.contains(closestVals[closestVals[i].length - 1][i])) {
                    forbidden.add(closestVals[closestVals[i].length - 1][i]);
                }
            }

            //var below records how many points closest to
            int[] totalNum = new int[50]; //change to 50
            for (int i = 0; i < closestVals.length; i++) {
                for (int j = 0; j < closestVals[i].length; j++) {
                    int val = closestVals[i][j];
                    if (val != -1) {
                    //if (!forbidden.contains(val)) {
                        totalNum[val]++;
                    }
                }
            }
            int largest = 0;
            for (int i = 0; i < totalNum.length; i++){
                if (totalNum[i] > largest) {
                    largest = totalNum[i];
                }
            }
            System.out.println(Arrays.toString(totalNum));
            System.out.println(largest);
        } catch (FileNotFoundException e) {
        }
    }
}
