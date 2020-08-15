import java.util.*;
import java.io.*;

public class Day1b {
    public static void main(String[] args) {
        try {
            File f = new File("Day1bFreq.txt");
            Scanner in = new Scanner(f);
            ArrayList<Integer> totals = new ArrayList<Integer>();
            ArrayList<Integer> freqs = new ArrayList<Integer>();
            int total = 0;
            totals.add(0);
            while (in.hasNext()) {
                freqs.add(Integer.parseInt(in.next()));
            }
            for (int idx = 0; idx < freqs.size(); idx++) {
                total += freqs.get(idx);
                if (totals.contains(total)) {
                    System.out.println(total);
                    System.exit(0);
                } else {
                    totals.add(total);
                }
                if (idx == freqs.size() - 1) {
                    idx = -1;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("help");
        }
    }
}
