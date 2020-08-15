import java.util.*;

public class Day {

    private int id;
    private int month;
    private int day;
    private int[] sleeps = new int[60];

    public Day(int m, int d) {
        month = m;
        day = d;
    }

    public void setId(int num) {
        id = num;
    }
    public void setAwake(int num) {
        sleeps[num] = 2;
    }
    public void setSleep(int num) {
        sleeps[num] = 1;
    }
    public void setID(int num) {
        id = num;
    }
    public void calibrate() {
        boolean isAwake = true;
        for (int i = 0; i < sleeps.length; i++) {
            if (sleeps[i] == 0) {
                if (isAwake) {
                    sleeps[i] = 2;
                } else {
                    sleeps[i] = 1;
                }
            } else if (sleeps[i] == 1) {
                isAwake = false;
            } else if (sleeps[i] == 2) {
                isAwake = true;
            }
        }
    }
    public int getID() {
        return id;
    }
    public int returnSum() {
        int ans = 0;
        for (int i = 0; i < sleeps.length; i++) {
            if (sleeps[i] == 1) {
                ans++;
            }
        }
        return ans;
    }
    public int[] getSchedule() {
        return sleeps;
    }
}
