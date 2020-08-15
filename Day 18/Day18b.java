import java.util.*;
import java.io.*;

public class Day18b {
    public static void main(String[] args) {
        try {
            File f = new File("Day18Area.txt");
            Scanner in = new Scanner(f);
            Acre[][] area = new Acre[50][50]; //change to 50 x 50
            int totalT = 0;
            int totalL = 0;

            for (int i = 0; in.hasNext(); i++) {
                String line = in.nextLine();
                for (int j = 0; j < line.length(); j++) {
                    area[i][j] = new Acre(line.charAt(j));
                }
            }

            for (int idx = 0; idx < 10000; idx++) {
                for (int i = 0; i < area.length; i++) {
                    for (int j = 0; j < area[i].length; j++) {
                        ArrayList<Acre> toAdd = new ArrayList<Acre>();
                        if (i == 0) {
                            toAdd.add(area[i + 1][j]);
                            if (j == 0) {
                                toAdd.add(area[i][j + 1]);
                                toAdd.add(area[i + 1][j + 1]);
                            } else if (j == area[i].length - 1) {
                                toAdd.add(area[i][j - 1]);
                                toAdd.add(area[i + 1][j - 1]);
                            } else {
                                toAdd.add(area[i][j + 1]);
                                toAdd.add(area[i + 1][j + 1]);
                                toAdd.add(area[i][j - 1]);
                                toAdd.add(area[i + 1][j - 1]);
                            }
                        } else if (i == area.length - 1) {
                            toAdd.add(area[i - 1][j]);
                            if (j == 0) {
                                toAdd.add(area[i][j + 1]);
                                toAdd.add(area[i - 1][j + 1]);
                            } else if (j == area[i].length - 1) {
                                toAdd.add(area[i][j - 1]);
                                toAdd.add(area[i - 1][j - 1]);
                            } else {
                                toAdd.add(area[i][j + 1]);
                                toAdd.add(area[i - 1][j + 1]);
                                toAdd.add(area[i][j - 1]);
                                toAdd.add(area[i - 1][j - 1]);
                            }
                        } else {
                            toAdd.add(area[i - 1][j]);
                            toAdd.add(area[i + 1][j]);
                            if (j == 0) {
                                toAdd.add(area[i][j + 1]);
                                toAdd.add(area[i - 1][j + 1]);
                                toAdd.add(area[i + 1][j + 1]);
                            } else if (j == area[i].length - 1) {
                                toAdd.add(area[i][j - 1]);
                                toAdd.add(area[i - 1][j - 1]);
                                toAdd.add(area[i + 1][j - 1]);
                            } else {
                                toAdd.add(area[i][j + 1]);
                                toAdd.add(area[i - 1][j + 1]);
                                toAdd.add(area[i][j - 1]);
                                toAdd.add(area[i - 1][j - 1]);
                                toAdd.add(area[i + 1][j - 1]);
                                toAdd.add(area[i + 1][j + 1]);
                            }
                        }
                        area[i][j].setChange(toAdd);
                    }
                }
                for (int i = 0; i < area.length; i++) {
                    for (int j = 0; j < area[i].length; j++) {
                        area[i][j].change();
                    }
                }
                for (int i = 0; i < area.length; i++) {
                    for (int j = 0; j < area[i].length; j++) {
                        char type = area[i][j].getType();
                        if (type == '|') {
                            totalT++;
                        }
                        if (type == '#') {
                            totalL++;
                        }
                    }
                }
                System.out.println("" + (totalT * totalL) + ", " + idx);
                totalT = 0;
                totalL = 0;
            } //to use this, find the pattern and then find the cycle. then mod 1000000000 by that cycle number and then put it in
        } catch (FileNotFoundException e) {
        }
    }
}
