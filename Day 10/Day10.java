import java.util.*;
import java.io.*;

public class Day10 {
    public static boolean anyNextToEachOther(int[][] coords) {
        boolean isIt = false;
        for (int i = 0; i < coords.length; i++) {
            int thisX = coords[i][0];
            int thisY = coords[i][1];
            for (int j = i + 1; j < coords.length; j++) {
                int thatX = coords[j][0];
                int thatY = coords[j][1];
                if (Math.abs(thatX - thisX) == 1) {
                    isIt = true;
                }
                if (Math.abs(thatY - thisY) == 1) {
                    isIt = true;
                }
            }
        }
        return isIt;
    }
    public static int howManyNextToEachOther(int[][] coords) {
        int total = 0;
        for (int i = 0; i < coords.length; i++) {
            int thisX = coords[i][0];
            int thisY = coords[i][1];
            for (int j = i + 1; j < coords.length; j++) {
                int thatX = coords[j][0];
                int thatY = coords[j][1];
                if (Math.abs(thatX - thisX) == 1) {
                    total++;
                } else if (Math.abs(thatY - thisY) == 1) {
                    total++;
                }
            }
        }
        return total;
    }
    public static void main(String[] args) {
        try {
            File f = new File("Day10Coords.txt");
            Scanner in = new Scanner(f);
            int time = 0;
            if (args.length == 1) {
                time = Integer.parseInt(args[0]);
            }
            int[][] coords = new int[379][4]; //change to 379
            char[][] grid;

            for (int idx = 0; in.hasNext(); idx++) {
                String line = in.nextLine();
                String[] vals = new String[4];
                vals[0] = line.substring(10, 16); //change to 10, 16 testing is 10,12
                vals[1] = line.substring(18, 24); //change to 18, 24 testing is 14,16
                vals[2] = line.substring(36, 38); //change to 36, 38 testing is 28,30
                vals[3] = line.substring(40, 42); //change to 40, 42 testing is 32,34
                for (int i = 0; i < vals.length; i++) {
                    if (vals[i].charAt(0) == ' ') {
                        vals[i] = vals[i].substring(1);
                    }
                }
                coords[idx][0] = Integer.parseInt(vals[0]);
                coords[idx][1] = Integer.parseInt(vals[1]);
                coords[idx][2] = Integer.parseInt(vals[2]);
                coords[idx][3] = Integer.parseInt(vals[3]);
            }
            if (time == 0) {
                boolean anyNext = false;
                for (; !anyNext; time++) {
                    for (int idx = 0; idx < coords.length; idx++) {
                        coords[idx][0] += coords[idx][0] + coords[idx][2];
                        coords[idx][1] += coords[idx][1] + coords[idx][3];
                    }
                    if (anyNextToEachOther(coords)) {
                        anyNext = true;
                    }
                }
                System.out.println(time);
            } else {
                int max = 0;
                int maxTime = 0;
                for (int idx = 1; idx < time + 1; idx++) {
                    for (int i = 0; i < coords.length; i++) {
                        coords[i][0] = coords[i][0] + coords[i][2];
                        coords[i][1] = coords[i][1] + coords[i][3];
                    }
                    int x = howManyNextToEachOther(coords);
                    if (x > max) {
                        max = x;
                        maxTime = idx;
                    }
                }
                System.out.println("" + max + ", " + maxTime);
/*
                int smallestX = coords[0][0];
                int smallestY = coords[0][1];
                int biggestX = coords[0][0];
                int biggestY = coords[0][1];
                for (int idx = 0; idx < coords.length; idx++) {
                    if (coords[idx][0] < smallestX) {
                        smallestX = coords[idx][0];
                    }
                    if (coords[idx][1] < smallestY) {
                        smallestY = coords[idx][1];
                    }
                    if (coords[idx][0] > biggestX) {
                        biggestX = coords[idx][0];
                    }
                    if (coords[idx][1] > biggestY) {
                        biggestY = coords[idx][1];
                    }
                }
                grid = new char[biggestY - smallestY + 1][biggestX - smallestX + 1];
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[i].length; j++) {
                        grid[i][j] = '.';
                    }
                }
                for (int idx = 0; idx < coords.length; idx++) {
                    grid[coords[idx][1] - smallestY][coords[idx][0] - smallestX] = '#';
                }
                for (int idx = 0; idx < grid.length; idx++) {
                    System.out.println(Arrays.toString(grid[idx]));
                }
                */

                //to use this, cross out the everything from 86 to 116 and then do guess and check
                //you should gues in the thousands or even ten thousands
                //after you feel like you got the right time, then uncross everything
                //that was crossed and cross everything thats uncrossed
            }
        } catch (FileNotFoundException e) {
        }
    }
}
