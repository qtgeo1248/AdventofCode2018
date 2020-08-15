import java.util.*;
import java.io.*;

public class Day7b {
    public static void main(String[] args) {
        try {
            File f = new File("Day7.txt");
            Scanner in = new Scanner(f);
            ArrayList<Character> done = new ArrayList<Character>();
            ArrayList<Character> toBeDone = new ArrayList<Character>();
            Step[] steps = new Step[101]; //change when testing to 101
            int time = 0;
            int[][] workers = new int[5][2]; //what letter they're doing rn
                                            //change to [5][2] when testing

            for (int idx = (int)'A'; idx < 'Z' + 1; idx++) { //change to Z when testing
                toBeDone.add((char)idx);
            }
            for (int idx = 0; in.hasNext(); idx++) {
                String line = in.nextLine();
                steps[idx] = new Step(line.charAt(5), line.charAt(36));
            }

            while (done.size() < 26) { //change when testing to 26
                for (int i = 0; i < toBeDone.size(); i++) { //change when testing to Z
                    boolean can = true;
                    for (int j = 0; j < steps.length; j++) {
                        if (!steps[j].canBeDone(done, toBeDone.get(i))) {
                            can = false;
                        }
                    }
                    if (can) {
                        boolean added = false;
                        for (int j = 0; j < workers.length && !added; j++) {
                            if (workers[j][0] == 0) {
                                int[] toAdd = {(int)toBeDone.get(i), toBeDone.get(i) - 'A' + 60}; //change to + 60 when testing
                                workers[j] = toAdd;
                                added = true;
                                toBeDone.remove(i);
                            }
                        }
                    }
                }
                for (int i = 0; i < workers.length; i++) {
                    if (workers[i][0] > 0) {
                        if (workers[i][1] > 0) {
                            workers[i][1]--;
                        } else if (workers[i][1] == 0){
                            done.add((char)workers[i][0]);
                            workers[i][0] = 0;
                        }
                    }
                }
                for (int i = 0; i < workers.length; i++) {
                    System.out.println(Arrays.toString(workers[i]));
                }
                time++;
            }
            System.out.println(time);
        } catch(FileNotFoundException e) {
        }
    }
}
