import java.util.*;
import java.io.*;

public class Day1a {
    public static void main(String[] args) {
        try {
            File f = new File("Day1aFreq.txt");
            Scanner in = new Scanner(f);
            int total = 0;
            while (in.hasNext()) {
                total += Integer.parseInt(in.next());
            }
            System.out.println(total);
        } catch (FileNotFoundException e) {
        }
    }
}
