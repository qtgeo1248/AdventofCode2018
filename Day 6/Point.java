import java.util.*;
import java.io.*;

public class Point {
    int x;
    int y;

    public Point(int a, int b) {
        x = a;
        y = b;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int dist(Point b) {
        return Math.abs(this.getX() - b.getX()) + Math.abs(this.getY() - b.getY());
    }

    public int minDist(Point[] points) {
        int smallest = this.dist(points[0]);
        int idx = 0;
        for (int i = 1; i < points.length; i++) {
            if (this.dist(points[i]) < smallest) {
                smallest = this.dist(points[i]);
                idx = i;
            }
        }
        for (int i = 0; i < points.length; i++) {
            if (this.dist(points[i]) == smallest && i != idx) {
                return -1;
            }
        }
        return idx;
    }

    public int totalDist(Point[] points) {
        int total = 0;
        for (int i = 0; i < points.length; i++) {
            total += this.dist(points[i]);
        }
        return total;
    }
}
