import java.util.*;
import java.io.*;

public class Day13b {
    public static void organize(ArrayList<Point> cars) {
        for (int i = 1; i < cars.size(); i++) {
            Point now = cars.get(i);
            int j = i - 1;
            while (j > -1 && cars.get(j).getY() > now.getY()) {
                cars.set(j + 1, cars.get(j));
                j--;
            }
            cars.set(j + 1, now);
        }
        for (int i = 1; i < cars.size(); i++) {
            Point now = cars.get(i);
            int j = i - 1;
            while (j > -1 && cars.get(j).getY() == now.getY() && cars.get(j).getX() > now.getX()) {
                cars.set(j + 1, cars.get(j));
                j--;
            }
            cars.set(j + 1, now);
        }
    }
    public static boolean anySame(ArrayList<Point> cars) {
        for (int i = 0; i < cars.size(); i++) {
            int thisx = cars.get(i).getX();
            int thisy = cars.get(i).getY();
            for (int j = i + 1; j < cars.size(); j++) {
                if (cars.get(j).getX() == thisx && cars.get(j).getY() == thisy) {
                    return true;
                }
            }
        }
        return false;
    }
    public static int whereXY(ArrayList<Point> cars, int x, int y) {
        for (int j = 0; j < cars.size(); j++) {
            if (cars.get(j).getX() == x && cars.get(j).getY() == y) {
                return j;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        try {
            File f = new File("Day13input.txt"); //has 150 lines, each with 150 chars
            Scanner in = new Scanner(f);
            char[][] grid = new char[150][150]; //change 6 by 12 to 150 by 150
            ArrayList<Point> cars = new ArrayList<Point>();

            for (int i = 0; in.hasNext(); i++) {
                String line = in.nextLine();
                for (int idx = 0; idx < line.length(); idx++) {
                    grid[i][idx] = line.charAt(idx);
                }
            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == '^') {
                        grid[i][j] = '|';
                        cars.add(new Point(j, i, 0));
                    }
                    if (grid[i][j] == '<') {
                        grid[i][j] = '-';
                        cars.add(new Point(j, i, 1));
                    }
                    if (grid[i][j] == 'v') {
                        grid[i][j] = '|';
                        cars.add(new Point(j, i, 2));
                    }
                    if (grid[i][j] == '>') {
                        grid[i][j] = '-';
                        cars.add(new Point(j, i, 3));
                    }
                }
            }

            organize(cars);

            boolean isDone = false;
            System.out.println(cars);
            while (cars.size() > 1 && !isDone) {
                for (int idx = 0; idx < cars.size() && !isDone; idx++) {
                    int x = cars.get(idx).getX();
                    int y = cars.get(idx).getY();
                    char type = grid[y][x];
                    if (type == '|') {
                        cars.get(idx).addY(cars.get(idx).getDirection() - 1);
                    } else if (type == '-') {
                        cars.get(idx).addX(cars.get(idx).getDirection() - 2);
                    } else if (type == '+') {
                        cars.get(idx).addIntersect();
                        cars.get(idx).changeDirection();
                        if (cars.get(idx).getDirection() % 2 == 0) {
                            cars.get(idx).addY(cars.get(idx).getDirection() - 1);
                        } else {
                            cars.get(idx).addX(cars.get(idx).getDirection() - 2);
                        }
                    } else if (type == '/') {
                        if (cars.get(idx).getDirection() == 0) {
                            cars.get(idx).setDirection(3);
                            cars.get(idx).addX(1);
                        } else if (cars.get(idx).getDirection() == 1){
                            cars.get(idx).setDirection(2);
                            cars.get(idx).addY(1);
                        } else if (cars.get(idx).getDirection() == 2) {
                            cars.get(idx).setDirection(1);
                            cars.get(idx).addX(-1);
                        } else if (cars.get(idx).getDirection() == 3){
                            cars.get(idx).setDirection(0);
                            cars.get(idx).addY(-1);
                        }
                    } else if (type == '\\') {
                        if (cars.get(idx).getDirection() == 0) {
                            cars.get(idx).setDirection(1);
                            cars.get(idx).addX(-1);
                        } else if (cars.get(idx).getDirection() == 3){
                            cars.get(idx).setDirection(2);
                            cars.get(idx).addY(1);
                        } else if (cars.get(idx).getDirection() == 1) {
                            cars.get(idx).setDirection(0);
                            cars.get(idx).addY(-1);
                        } else if (cars.get(idx).getDirection() == 2){
                            cars.get(idx).setDirection(3);
                            cars.get(idx).addX(1);
                        }
                    }
                    if (anySame(cars)) {
                        int thisx = cars.get(idx).getX();
                        int thisy = cars.get(idx).getY();
                        int i = whereXY(cars, thisx, thisy);
                        if (idx == i) {
                            System.out.println(cars);
                            cars.remove(idx);
                            cars.remove(idx);
                            idx--;
                            System.out.println(cars);
                        } else {
                            System.out.println(cars);
                            cars.remove(i);
                            cars.remove(i);
                            idx = idx - 2;
                            System.out.println(cars);
                        }
                        if (idx < 0) {
                            idx = -1;
                        }
                    }
                }
                organize(cars);
            }
            System.out.println(cars.get(0));
        } catch (FileNotFoundException e) {
        }
    }
}
