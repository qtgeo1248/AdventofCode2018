import java.util.*;
import java.io.*;

public class Day23a {
    public static void main(String[] args) {
        try {
            File f = new File("Day23Nanobots.txt");
            Scanner in = new Scanner(f);
            Nanobots[] all = new Nanobots[1000]; //change to 1000
            int count = 0;

            for (int idx = 0; in.hasNext(); idx++) {
                String line = in.nextLine();
                int x = Integer.parseInt(line.substring(line.indexOf("<") + 1, line.indexOf(",")));
                int y = Integer.parseInt(line.substring(line.indexOf(",") + 1, line.indexOf(",", line.indexOf(",") + 1)));
                int z = Integer.parseInt(line.substring(line.indexOf(",", line.indexOf(",") + 1) + 1, line.indexOf(">")));
                int r = Integer.parseInt(line.substring(line.indexOf("r=") + 2));
                all[idx] = new Nanobots(x, y, z, r);
            }

            Nanobots greatest = all[0];
            for (int idx = 1; idx < all.length; idx++) {
                if (greatest.getR() < all[idx].getR()) {
                    greatest = all[idx];
                }
            }

            for (int idx = 0; idx < all.length; idx++) {
                if (greatest.distance(all[idx]) <= greatest.getR()) {
                    count++;
                }
            }
            System.out.println(count);
        } catch (FileNotFoundException e) {
        }
    }
}
