import java.util.*;
import java.io.*;

public class Day2a {
    public static void main(String[] args) {
        try {
            File f = new File("Day2BoxID.txt");
            Scanner in = new Scanner(f);
            int twos = 0;
            int threes = 0;
            while (in.hasNext()) {
                String boxid = in.nextLine();
                int[] chars = new int[26];
                for (int idx = 0; idx < boxid.length(); idx++) {
                    chars[boxid.charAt(idx) - 'a']++;
                }
                boolean isDone = false;
                for (int idx = 0; !isDone && idx < chars.length; idx++) {
                    if (chars[idx] == 2) {
                        twos++;
                        isDone = true;
                    }
                }
                isDone = false;
                for (int idx = 0; !isDone && idx < chars.length; idx++) {
                    if (chars[idx] == 3) {
                        threes++;
                        isDone = true;
                    }
                }
            }
            System.out.println(twos * threes);
        } catch (FileNotFoundException e){
        }
    }
}
