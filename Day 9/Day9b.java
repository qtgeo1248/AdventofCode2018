import java.util.*;
import java.io.*;

public class Day9b {
    public static void main(String[] args) {
        try {
            File f = new File("Day9Game.txt");
            Scanner in = new Scanner(f);
            String line = in.nextLine();
            int numPlayers = Integer.parseInt(line.substring(0, line.indexOf("pl") - 1));
            int numMarbles = Integer.parseInt(line.substring(line.indexOf("h") + 2, line.indexOf("po") - 1));
            LinkedList<Integer> gameBoard = new LinkedList<Integer>();
            long[] points = new long[numPlayers];
            int currentMarber = 1; // do -1 % numPlayers + 1 for the current Player
            int currentIdx = 0;

            gameBoard.add(0);
            // remember!!! gameBoard = rotate(gameBoard, thing)
            for (int idx = 1; idx < numMarbles * 100 + 1; idx++) {
                if (idx == 1) {
                    gameBoard.add(1);
                } else if (idx == 2) {
                    gameBoard.add(1, 2);
                    currentIdx = 1;
                } else if (idx % 23 == 0){
                    points[(idx - 1) % numPlayers] += idx + gameBoard.get(Math.floorMod((currentIdx - 7), gameBoard.size()));
                    int size = gameBoard.size();
                    gameBoard.remove(Math.floorMod((currentIdx - 7), size));
                    currentIdx = Math.floorMod((currentIdx - 7), gameBoard.size());
                } else {
                    currentIdx = (currentIdx + 2) % gameBoard.size();
                    gameBoard.add(currentIdx, idx);
                }
                System.out.println(Arrays.toString(points));
            }

            long largest = -1;
            for (int idx = 0; idx < points.length; idx++) {
                if (points[idx] > largest) {
                    largest = points[idx];
                }
            }
            System.out.println(largest);
        } catch (FileNotFoundException e) {
        }
    }
}
