import java.util.*;
import java.io.*;

public class Day6b {
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

            int total = 0;
            for (int i = -2000; i < 2000; i++) {
                for (int j = -2000; j < 2000; j++) {
                    Point a = new Point(i, j);
                    int val = a.totalDist(points);
                    if (val < 10000) {
                        total++;
                    }
                }
            }

            System.out.println(total);
        } catch (FileNotFoundException e) {
        }
    }
}
