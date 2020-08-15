import java.util.*;
import java.io.*;

public class Day14b { // thanks to Angry Kittens on reddit
	public Day14b() {
		part1();
	}

	int current1 = 3;
	int p1 = 0;
	int p2 = 1;
	int current2 = 7;
	ArrayList<Integer> completed = new ArrayList<Integer>();
	int input = 704321;

	public void part1() {
		completed.add(3);
		completed.add(7);
		int i = 0;
		while (i < 21000000) {
			current1 = completed.get(p1);
			current2 = completed.get(p2);
			int total = current1 + current2;
			if (total > 9) {
				completed.add(total/10);
				completed.add(total%10);
			}else {
				completed.add(total);
			}
			p1 = (completed.get(p1) +p1 + 1) % completed.size();
			p2 = (completed.get(p2) +p2 + 1) % completed.size();
			i++;
		}
        try {
            findSequence();
        } catch (FileNotFoundException e) {
        }
	}

	private void findSequence() throws FileNotFoundException {
        File f = new File("Day14Guess.txt");
        Scanner in = new Scanner(f);
		String comp = in.nextLine();
		for (int x = 0; x < completed.size()-5; x++) {
			String c2 = ""+completed.get(x)+completed.get(x+1)+completed.get(x+2)+completed.get(x+3)+completed.get(x+4)+completed.get(x+5);
			if (c2.equals(comp)) {
				System.out.println(x);
				return;
			}
		}
	}
    public static void main(String[] args) {
        Day14b ans = new Day14b();
    }
}
