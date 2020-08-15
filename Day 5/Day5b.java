import java.util.*;
import java.io.*;

public class Day5b {
    public static String removePairs(String line) {
        boolean hasPairs = true;
        while (hasPairs) {
            hasPairs = false;
            for (int idx = 0; idx < line.length() - 1; idx++) {
                if (Math.abs(line.charAt(idx) - line.charAt(idx + 1)) == 32) {
                    String front = line.substring(0, idx);
                    String back = line.substring(idx + 2);
                    line = front + back;
                    hasPairs = true;
                    idx = 0;
                }
            }
        }
        String result = "";
        for (int i = 0; i < line.length(); i++) {
            result += line.charAt(i);
        }
        return result;
    }
    public static void main(String[] args) {
        try {
            File f = new File("Day5Polymers.txt");
            int smallest = 10000;

            for (int idx = (int)'A'; idx < 1 + (int)'Z'; idx++) {
                Scanner in = new Scanner(f);
                String line = in.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == (char)idx || line.charAt(i) == (char)(idx + 32)) {
                        String front = line.substring(0, i);
                        String back = line.substring(i + 1);
                        line = front + back;
                        i--;
                    }
                }
                String result = removePairs(line);
                if (result.length() < smallest) {
                    smallest = result.length();
                }
            }
            System.out.println(smallest);
        } catch (FileNotFoundException e) {
        }
    }
}
