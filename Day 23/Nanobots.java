import java.util.*;

public class Nanobots {
    private int x;
    private int y;
    private int z;
    private int r;

    public Nanobots(int a, int b, int c, int s) {
        x = a;
        y = b;
        z = c;
        r = s;
    }

    public int distance(Nanobots B) {
        return Math.abs(B.x - x) + Math.abs(B.y - y) + Math.abs(B.z - z);
    }

    public int getR() {
        return r;
    }

    public String toString() {
        return "[" + x + ", " + y + ", " + z + ", " + r + "]";
    }
}
