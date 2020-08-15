import java.util.*;
import java.io.*;

public class Day13a {
    public static void organize(Point[] cars) {
        for (int i = 1; i < cars.length; i++) {
            Point now = cars[i];
            int j = i - 1;
            while (j > -1 && cars[j].getY() > now.getY()) {
                cars[j + 1] = cars[j];
                j--;
            }
            cars[j + 1] = now;
        }
        for (int i = 1; i < cars.length; i++) {
            Point now = cars[i];
            int j = i - 1;
            while (j > -1 && cars[j].getY() == now.getY() && cars[j].getX() > now.getX()) {
                cars[j + 1] = cars[j];
                j--;
            }
            cars[j + 1] = now;
        }
    }
    public static boolean anySame(Point[] cars) {
        for (int i = 0; i < cars.length; i++) {
            int thisx = cars[i].getX();
            int thisy = cars[i].getY();
            for (int j = i + 1; j < cars.length; j++) {
                if (cars[j].getX() == thisx && cars[j].getY() == thisy) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        try {
            File f = new File("Day13Track.txt"); //has 150 lines, each with 150 chars
            Scanner in = new Scanner(f);
            char[][] grid = new char[150][150]; //change 6 by 12 to 150 by 150
            Point[] cars = new Point[17]; //change 2 to 17

            for (int i = 0; in.hasNext(); i++) {
                String line = in.nextLine();
                for (int idx = 0; idx < line.length(); idx++) {
                    grid[i][idx] = line.charAt(idx);
                }
            }
            int gidx = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == '^') {
                        grid[i][j] = '|';
                        cars[gidx] = new Point(j, i, 0);
                        gidx++;
                    }
                    if (grid[i][j] == '<') {
                        grid[i][j] = '-';
                        cars[gidx] = new Point(j, i, 1);
                        gidx++;
                    }
                    if (grid[i][j] == 'v') {
                        grid[i][j] = '|';
                        cars[gidx] = new Point(j, i, 2);
                        gidx++;
                    }
                    if (grid[i][j] == '>') {
                        grid[i][j] = '-';
                        cars[gidx] = new Point(j, i, 3);
                        gidx++;
                    }
                }
            }

            organize(cars);

            boolean isDone = false;
            int tick = 0;
            System.out.println(Arrays.toString(cars));
            while (!isDone) {
                tick++;
                for (int idx = 0; idx < cars.length && !isDone; idx++) {
                    int x = cars[idx].getX();
                    int y = cars[idx].getY();
                    char type = grid[y][x];
                    if (type == '|') {
                        cars[idx].addY(cars[idx].getDirection() - 1);
                    } else if (type == '-') {
                        cars[idx].addX(cars[idx].getDirection() - 2);
                    } else if (type == '+') {
                        cars[idx].addIntersect();
                        cars[idx].changeDirection();
                        if (cars[idx].getDirection() % 2 == 0) {
                            cars[idx].addY(cars[idx].getDirection() - 1);
                        } else {
                            cars[idx].addX(cars[idx].getDirection() - 2);
                        }
                    } else if (type == '/') {
                        if (cars[idx].getDirection() == 0) {
                            cars[idx].setDirection(3);
                            cars[idx].addX(1);
                        } else if (cars[idx].getDirection() == 1){
                            cars[idx].setDirection(2);
                            cars[idx].addY(1);
                        } else if (cars[idx].getDirection() == 2) {
                            cars[idx].setDirection(1);
                            cars[idx].addX(-1);
                        } else if (cars[idx].getDirection() == 3){
                            cars[idx].setDirection(0);
                            cars[idx].addY(-1);
                        }
                    } else if (type == '\\') {
                        if (cars[idx].getDirection() == 0) {
                            cars[idx].setDirection(1);
                            cars[idx].addX(-1);
                        } else if (cars[idx].getDirection() == 3){
                            cars[idx].setDirection(2);
                            cars[idx].addY(1);
                        } else if (cars[idx].getDirection() == 1) {
                            cars[idx].setDirection(0);
                            cars[idx].addY(-1);
                        } else if (cars[idx].getDirection() == 2){
                            cars[idx].setDirection(3);
                            cars[idx].addX(1);
                        }
                    }
                    if (anySame(cars)) {
                        isDone = true;
                        System.out.println("" + cars[idx].getX() + ", " + cars[idx].getY());
                    }
                }
                organize(cars);
            }
            System.out.println(Arrays.toString(cars));
        } catch (FileNotFoundException e) {
        }
    }
}
