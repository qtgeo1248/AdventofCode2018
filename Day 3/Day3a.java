import java.util.*;
import java.io.*;

public class Day3a {
    public static void main(String[] args) {
        try {
            File f = new File("Day3Claims.txt");
            Scanner in = new Scanner(f);

            int[][] fabric = new int[2000][2000];
            for (int i = 0; i < fabric.length; i++) {
                for (int j = 0; j < fabric[i].length; j++) {
                    fabric[i][j] = 0;
                }
            }
            while (in.hasNext()) {
                String id = in.nextLine();
                int startX = Integer.parseInt(id.substring(id.indexOf("@") + 2, id.indexOf(",")));
                int startY = Integer.parseInt(id.substring(id.indexOf(",") + 1, id.indexOf(":")));
                int stepX = Integer.parseInt(id.substring(id.indexOf(":") + 2, id.indexOf("x")));
                int stepY = Integer.parseInt(id.substring(id.indexOf("x") + 1));
                for (int i = startY; i < startY + stepY; i++) {
                    for (int j = startX; j < startX + stepX; j++) {
                        fabric[i][j]++;
                    }
                }
            }
            int count = 0;
            for (int i = 0; i < fabric.length; i++) {
                for (int j = 0; j <fabric.length; j++) {
                    if (fabric[i][j] >= 2) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        } catch (FileNotFoundException e) {
        }
    }
}
