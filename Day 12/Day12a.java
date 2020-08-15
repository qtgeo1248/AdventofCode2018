import java.util.*;
import java.io.*;

public class Day12a {
    public static void main(String[] args) {
        try {
            File f = new File("Day12Pots.txt");
            Scanner in = new Scanner(f);
            Scanner in1 = new Scanner(f);
            String statetemp = in.nextLine().substring(15);
            char[] state;
            String[][] notes;
            int ans = 0;

            for (int idx = 0; idx < 1000; idx++) {
                statetemp = "." + statetemp + ".";
            }
            state = new char[statetemp.length()];
            for (int idx = 0; idx < statetemp.length(); idx++) {
                state[idx] = statetemp.charAt(idx);
            }
            in.nextLine();
            int total = 0;
            while (in.hasNext()) {
                total++;
                in.nextLine();
            }
            notes = new String[total][2];
            in1.nextLine();
            in1.nextLine();
            for (int idx = 0; in1.hasNext(); idx++) {
                String line = in1.nextLine();
                notes[idx][0] = line.substring(0, 5);
                notes[idx][1] = line.substring(9, 10);
            }
            int gen = 0;
            while (gen < 20) {
                gen++;
                char[] changeInto = new char[state.length];

                for (int idx = 0; idx < notes.length; idx++) {
                    String note = notes[idx][0];
                    for (int j = 0; j < state.length - 4; j++) {
                        String part = "" + state[j] + state[j + 1] + state[j + 2] + state[j + 3] + state[j + 4];
                        if (part.equals(note)) {
                            changeInto[j + 2] = notes[idx][1].charAt(0);
                        }
                    }
                }
                for (int idx = 0; idx < state.length; idx++) {
                    if (changeInto[idx] != '#' && changeInto[idx] != '.') {
                        changeInto[idx] = '.';
                    }
                }
                state = changeInto;
            }
            for (int idx = 0; idx < state.length; idx++) {
                if (state[idx] == '#') {
                    ans += idx - 1000;
                }
            }
            System.out.println(ans); //change 23 to whatever thing you get as a pattern
        } catch (FileNotFoundException e) {
        }
    }
}
