import java.util.ArrayList;

public class Acre {
    private char type;
    private char changeTo;

    public Acre(char t) {
        type = t;
        changeTo = t;
    }

    public String toString() {
        return "" + type;
    }

    public char getType() {
        return type;
    }

    public void setChange(ArrayList<Acre> adjacent) {
        int totalT = 0;
        int totalL = 0;
        for (int idx = 0; idx < adjacent.size(); idx++) {
            char t = adjacent.get(idx).getType();
            if (t == '|') {
                totalT++;
            }
            if (t == '#') {
                totalL++;
            }
        }
        if (type == '.' && totalT >= 3) {
            changeTo = '|';
        }
        if (type == '|' && totalL >= 3) {
            changeTo = '#';
        }
        if (type == '#' && (totalL < 1 || totalT < 1)) {
            changeTo = '.';
        }
    }

    public void change() {
        type = changeTo;
    }
}
