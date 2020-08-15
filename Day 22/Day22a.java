import java.util.*;
import java.io.*;

public class Day22a {
    public static void main(String[] args) {
        try {
            File f = new File("Day22Coords.txt");
            Scanner in = new Scanner(f);
            int depth = Integer.parseInt(in.nextLine().substring(7));
            int target = Integer.parseInt(in.nextLine().substring(8));
            Region[][] cave = new Region[target + 1][target + 1];
            int risk = 0;

            for (int i = 0; i < cave.length; i++) {
                for (int j = 0; j < cave[i].length; j++) {
                    if (i == 0 || j == 0) {
                        cave[i][j] = new Region(j * 16807 + i * 48271);
                        cave[i][j].getErosion(depth);
                    } else if (i == target && j == target) {
                        cave[i][j] = new Region(0);
                    } else {
                        cave[i][j] = new Region(cave[i][j - 1].getErosion() * cave[i - 1][j].getErosion());
                        cave[i][j].getErosion(depth);
                    }
                }
            }
            for (int i = 0; i < cave.length; i++) {
                for (int j = 0; j < cave[i].length; j++) {
                    caveTypes[i][j] = cave[i][j].getType();
                    char type = caveTypes[i][j];
                    if (type == '.') {
                        risk += 0;
                    } else if (type == '=') {
                        risk += 1;
                    } else if (type == '|') {
                        risk += 2;
                    }
                }
            }
            System.out.println(risk);
        } catch (FileNotFoundException e) {
        }
    }
}
