import java.util.*;
import java.io.*;

public class Day14a {
    public static void main(String[] args) {
        try {
            File f = new File("Day14Guess.txt");
            Scanner in = new Scanner(f);
            int guess = in.nextInt();
            int idx1 = 0;
            int idx2 = 1;
            ArrayList<Integer> recipes = new ArrayList<Integer>();
            String ans = "";

            recipes.add(3);
            recipes.add(7);

            while (recipes.size() < guess + 11) {
                int total = recipes.get(idx1) + recipes.get(idx2);
                if (total < 10) {
                    recipes.add(total);
                } else {
                    recipes.add(total / 10);
                    recipes.add(total % 10);
                }
                idx1 = (idx1 + recipes.get(idx1) + 1) % recipes.size();
                idx2 = (idx2 + recipes.get(idx2) + 1) % recipes.size();
            }
            for (int idx = guess; idx < guess + 10; idx++) {
                ans += recipes.get(idx);
            }
            System.out.println(ans);
        } catch (FileNotFoundException e) {
        }
    }
}
