import java.util.*;
import java.io.*;

public class Day7a {
    public static void main(String[] args) {
        try {
            File f = new File("Day7.txt");
            Scanner in = new Scanner(f); // there are 101 steps
            ArrayList<Character> done = new ArrayList<Character>();
            Step[] steps = new Step[101]; //change when testing to 101

            for (int idx = 0; in.hasNext(); idx++) {
                String line = in.nextLine();
                steps[idx] = new Step(line.charAt(5), line.charAt(36));
            }

            while (done.size() < 26) { //change when testing to 26
                for (int i = (int)'A'; i < (int)'Z' + 1; i++) { //change when testing to Z
                    boolean can = true;
                    for (int j = 0; j < steps.length; j++) {
                        if (!steps[j].canBeDone(done, (char)i)) {
                            can = false;
                        }
                    }
                    if (can && !done.contains((char)i)) {
                        done.add((char)i);
                        i = (int)'A' - 1;
                    }
                }
            }

            for (int idx = 0; idx < done.size(); idx++) {
                System.out.print(done.get(idx));
            }
            System.out.println();
        } catch(FileNotFoundException e) {
        }
    }
}
