import java.util.*;
import java.io.*;

public class Day16a {
    public static int[] addr(int[] before, int[] step) {
        int[] ans = new int[4];
        int A = step[1];
        int B = step[2];
        int C = step[3];
        for (int idx = 0; idx < 4; idx++) {
            ans[idx] = before[idx];
        }
        return ans;
    }
    public static void main(String[] args) {
        try {
            File f = new File("Day16Samples.txt");
            Scanner in = new Scanner(f);
            int[][] befores = new int[1][4]; //change to 790
            int[][] steps = new int[1][4]; //change to 790
            int[][] afters = new int[1][4]; //change to 790
            int count = 0;
            for (int idx = 0; in.hasNext();) {
                String line = in.nextLine();
                if (line.indexOf("Before") > -1) {
                    befores[idx][0] = Integer.parseInt(line.substring(9, 10));
                    befores[idx][1] = Integer.parseInt(line.substring(12, 13));
                    befores[idx][2] = Integer.parseInt(line.substring(15, 16));
                    befores[idx][3] = Integer.parseInt(line.substring(18, 19));
                    line = in.nextLine();
                    int need = line.indexOf(" ");
                    steps[idx][0] = Integer.parseInt(line.substring(0, need));
                    steps[idx][1] = Integer.parseInt(line.substring(need + 1, need + 2));
                    steps[idx][2] = Integer.parseInt(line.substring(need + 3, need + 4));
                    steps[idx][3] = Integer.parseInt(line.substring(need + 5, need + 6));
                    line = in.nextLine();
                    afters[idx][0] = Integer.parseInt(line.substring(9, 10));
                    afters[idx][1] = Integer.parseInt(line.substring(12, 13));
                    afters[idx][2] = Integer.parseInt(line.substring(15, 16));
                    afters[idx][3] = Integer.parseInt(line.substring(18, 19));
                    idx++;
                }
            }
            for (int idx = 0; idx < befores.length; idx++) {

            }
        } catch (FileNotFoundException e) {
        }
    }
}
