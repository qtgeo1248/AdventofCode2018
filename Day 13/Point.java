public class Point {
    int x;
    int y;
    int direction;
    int howManyIntersecs = 0;

    public Point(int a, int b, int dir) {
        x = a;
        y = b;
        direction = dir;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDirection() { //0 is north, 1 is west, 2 is south, 3 is east
        return direction;
    }

    public void changeDirection() { //do addIntersect, then change direc
        int change;
        if (howManyIntersecs % 3 == 1) {
            change = 1;
        } else if (howManyIntersecs % 3 == 2) {
            change = 0;
        } else {
            change = -1;
        }
        direction = (direction + change + 4) % 4;
    }

    public void setDirection(int next) {
        direction = next;
    }
    
    public void addIntersect() {
        howManyIntersecs++;
    }

    public void addX(int change) {
        x += change;
    }

    public void addY(int change) {
        y += change;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
