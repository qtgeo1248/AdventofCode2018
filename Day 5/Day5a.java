import java.util.*;
import java.io.*;

public class Day5a {
    public static void main(String[] args) {
        try {
            File f = new File("Day5Polymers.txt");
            Scanner in = new Scanner(f); //a capital and lowercase differ by 32

            String line = "";
            line = in.nextLine();
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
            String ans = "";
            for (int idx = 0; idx < line.length(); idx++) {
                ans += line.charAt(idx);
            }
            System.out.println(ans.length());
        } catch (FileNotFoundException e) {
        }
    }
}
