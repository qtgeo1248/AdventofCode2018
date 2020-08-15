public class Region {
    int gIdx;
    int erosion;
    char type;

    public Region(int input) {
        gIdx = input;
    }

    public int getGIdx() {
        return gIdx;
    }

    public int getErosion() {
        return erosion;
    }

    public int getErosion(int depth) {
        erosion = (gIdx + depth) % 20183;
        return erosion;
    }

    public char getType() {
        int mod = erosion % 3;
        if (mod == 0) {
            type = '.';
        } else if (mod == 1) {
            type = '=';
        } else {
            type = '|';
        }
        return type;
    }
}
