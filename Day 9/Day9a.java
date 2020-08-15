import java.util.*;
import java.io.*;

public class Day9a {
    public static ArrayList<Integer> rotate(ArrayList<Integer> arr, int point) { //does it by so the value you want is first
        int goal = arr.indexOf(point);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int idx = goal; idx < arr.size(); idx++) {
            ans.add(arr.get(idx));
        }
        for (int idx = 0; idx < goal; idx++) {
            ans.add(arr.get(idx));
        }
        return ans;
    }
    public static void main(String[] args) {
        try {
            File f = new File("Day9Game.txt");
            Scanner in = new Scanner(f);
            String line = in.nextLine();
            int numPlayers = Integer.parseInt(line.substring(0, line.indexOf("pl") - 1));
            int numMarbles = Integer.parseInt(line.substring(line.indexOf("h") + 2, line.indexOf("po") - 1));
            ArrayList<Integer> gameBoard = new ArrayList<Integer>();
            int[] points = new int[numPlayers];
            int currentMarber = 1; // do -1 % numPlayers + 1 for the current Player

            gameBoard.add(0);
            // remember!!! gameBoard = rotate(gameBoard, thing)
            for (int idx = 1; idx < numMarbles + 1; idx++) {
                if (idx == 1) {
                    gameBoard.add(1);
                } else if (idx == 2) {
                    gameBoard.add(1, 2);
                    gameBoard = rotate(gameBoard, 2);
                } else if (idx % 23 == 0){
                    points[(idx - 1) % numPlayers] += idx + gameBoard.get(gameBoard.size() - 7);
                    gameBoard.remove(gameBoard.size() - 7);
                    gameBoard = rotate(gameBoard, gameBoard.get(gameBoard.size() - 6));
                } else {
                    gameBoard.add(2, idx);
                    gameBoard = rotate(gameBoard, idx);
                }
            }

            int largest = -1;
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
