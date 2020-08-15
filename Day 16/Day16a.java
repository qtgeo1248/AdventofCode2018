import java.util.*;
import java.io.*;

public class Day16a {
    public static int[] addr(int[] before, int[] step) {
        int[] ans = new int[4];
        int A = step[1];
        int B = step[2];
        int C = step[3];
        for (int idx = 0; idx < 4; idx++) {
            ans[idx] = before[idx];
        }
        ans[C] = ans[A] + ans[B];
        return ans;
    }
    public static int[] addi(int[] before, int[] step) {
        int[] ans = new int[4];
        int A = step[1];
        int B = step[2];
        int C = step[3];
        for (int idx = 0; idx < 4; idx++) {
            ans[idx] = before[idx];
        }
        ans[C] = ans[A] + B;
        return ans;
    }
    public static int[] mulr(int[] before, int[] step) {
        int[] ans = new int[4];
        int A = step[1];
        int B = step[2];
        int C = step[3];
        for (int idx = 0; idx < 4; idx++) {
            ans[idx] = before[idx];
        }
        ans[C] = ans[A] * ans[B];
        return ans;
    }
    public static int[] muli(int[] before, int[] step) {
        int[] ans = new int[4];
        int A = step[1];
        int B = step[2];
        int C = step[3];
        for (int idx = 0; idx < 4; idx++) {
            ans[idx] = before[idx];
        }
        ans[C] = ans[A] * B;
        return ans;
    }
    public static int[] banr(int[] before, int[] step) {
        int[] ans = new int[4];
        int A = step[1];
        int B = step[2];
        int C = step[3];
        for (int idx = 0; idx < 4; idx++) {
            ans[idx] = before[idx];
        }
        ans[C] = ans[A] & ans[B];
        return ans;
    }
    public static int[] bani(int[] before, int[] step) {
        int[] ans = new int[4];
        int A = step[1];
        int B = step[2];
        int C = step[3];
        for (int idx = 0; idx < 4; idx++) {
            ans[idx] = before[idx];
        }
        ans[C] = ans[A] & B;
        return ans;
    }
    public static int[] borr(int[] before, int[] step) {
        int[] ans = new int[4];
        int A = step[1];
        int B = step[2];
        int C = step[3];
        for (int idx = 0; idx < 4; idx++) {
            ans[idx] = before[idx];
        }
        ans[C] = ans[A] | ans[B];
        return ans;
    }
    public static int[] bori(int[] before, int[] step) {
        int[] ans = new int[4];
        int A = step[1];
        int B = step[2];
        int C = step[3];
        for (int idx = 0; idx < 4; idx++) {
            ans[idx] = before[idx];
        }
        ans[C] = ans[A] | B;
        return ans;
    }
    public static int[] setr(int[] before, int[] step) {
        int[] ans = new int[4];
        int A = step[1];
        int B = step[2];
        int C = step[3];
        for (int idx = 0; idx < 4; idx++) {
            ans[idx] = before[idx];
        }
        ans[C] = ans[A];
        return ans;
    }
    public static int[] seti(int[] before, int[] step) {
        int[] ans = new int[4];
        int A = step[1];
        int B = step[2];
        int C = step[3];
        for (int idx = 0; idx < 4; idx++) {
            ans[idx] = before[idx];
        }
        ans[C] = A;
        return ans;
    }
    public static int[] gtir(int[] before, int[] step) {
        int[] ans = new int[4];
        int A = step[1];
        int B = step[2];
        int C = step[3];
        for (int idx = 0; idx < 4; idx++) {
            ans[idx] = before[idx];
        }
        if (A > ans[B]) {
            ans[C] = 1;
        } else {
            ans[C] = 0;
        }
        return ans;
    }
    public static int[] gtri(int[] before, int[] step) {
        int[] ans = new int[4];
        int A = step[1];
        int B = step[2];
        int C = step[3];
        for (int idx = 0; idx < 4; idx++) {
            ans[idx] = before[idx];
        }
        if (ans[A] > B) {
            ans[C] = 1;
        } else {
            ans[C] = 0;
        }
        return ans;
    }
    public static int[] gtrr(int[] before, int[] step) {
        int[] ans = new int[4];
        int A = step[1];
        int B = step[2];
        int C = step[3];
        for (int idx = 0; idx < 4; idx++) {
            ans[idx] = before[idx];
        }
        if (ans[A] > ans[B]) {
            ans[C] = 1;
        } else {
            ans[C] = 0;
        }
        return ans;
    }
    public static int[] eqir(int[] before, int[] step) {
        int[] ans = new int[4];
        int A = step[1];
        int B = step[2];
        int C = step[3];
        for (int idx = 0; idx < 4; idx++) {
            ans[idx] = before[idx];
        }
        if (A == ans[B]) {
            ans[C] = 1;
        } else {
            ans[C] = 0;
        }
        return ans;
    }
    public static int[] eqri(int[] before, int[] step) {
        int[] ans = new int[4];
        int A = step[1];
        int B = step[2];
        int C = step[3];
        for (int idx = 0; idx < 4; idx++) {
            ans[idx] = before[idx];
        }
        if (ans[A] == B) {
            ans[C] = 1;
        } else {
            ans[C] = 0;
        }
        return ans;
    }
    public static int[] eqrr(int[] before, int[] step) {
        int[] ans = new int[4];
        int A = step[1];
        int B = step[2];
        int C = step[3];
        for (int idx = 0; idx < 4; idx++) {
            ans[idx] = before[idx];
        }
        if (ans[A] == ans[B]) {
            ans[C] = 1;
        } else {
            ans[C] = 0;
        }
        return ans;
    }
    public static boolean isPoss(int[] before, int[] step, int[] after) {
        int count = 0;
        if (Arrays.equals(after, addr(before, step))) {
            count++;
        } if (Arrays.equals(after, addi(before, step))) {
            count++;
        } if (Arrays.equals(after, mulr(before, step))) {
            count++;
        } if (Arrays.equals(after, muli(before, step))) {
            count++;
        } if (Arrays.equals(after, banr(before, step))) {
            count++;
        } if (Arrays.equals(after, bani(before, step))) {
            count++;
        } if (Arrays.equals(after, borr(before, step))) {
            count++;
        } if (Arrays.equals(after, bori(before, step))) {
            count++;
        } if (Arrays.equals(after, setr(before, step))) {
            count++;
        } if (Arrays.equals(after, seti(before, step))) {
            count++;
        } if (Arrays.equals(after, gtir(before, step))) {
            count++;
        } if (Arrays.equals(after, gtri(before, step))) {
            count++;
        } if (Arrays.equals(after, gtrr(before, step))) {
            count++;
        } if (Arrays.equals(after, eqir(before, step))) {
            count++;
        } if (Arrays.equals(after, eqri(before, step))) {
            count++;
        } if (Arrays.equals(after, eqrr(before, step))) {
            count++;
        }
        return count >= 3;
    }
    public static void main(String[] args) {
        try {
            File f = new File("Day16Samples.txt");
            Scanner in = new Scanner(f);
            int[][] befores = new int[790][4]; //change to 790
            int[][] steps = new int[790][4]; //change to 790
            int[][] afters = new int[790][4]; //change to 790
            int count = 0;
            for (int idx = 0; in.hasNext();) {
                String line = in.nextLine();
                if (line.indexOf("Before") > -1) {
                    befores[idx][0] = Integer.parseInt(line.substring(9, 10));
                    befores[idx][1] = Integer.parseInt(line.substring(12, 13));
                    befores[idx][2] = Integer.parseInt(line.substring(15, 16));
                    befores[idx][3] = Integer.parseInt(line.substring(18, 19));
                    line = in.nextLine();
                    int need = line.indexOf(" ");
                    steps[idx][0] = Integer.parseInt(line.substring(0, need));
                    steps[idx][1] = Integer.parseInt(line.substring(need + 1, need + 2));
                    steps[idx][2] = Integer.parseInt(line.substring(need + 3, need + 4));
                    steps[idx][3] = Integer.parseInt(line.substring(need + 5, need + 6));
                    line = in.nextLine();
                    afters[idx][0] = Integer.parseInt(line.substring(9, 10));
                    afters[idx][1] = Integer.parseInt(line.substring(12, 13));
                    afters[idx][2] = Integer.parseInt(line.substring(15, 16));
                    afters[idx][3] = Integer.parseInt(line.substring(18, 19));
                    idx++;
                }
            }
            for (int idx = 0; idx < befores.length; idx++) {
                if (isPoss(befores[idx], steps[idx], afters[idx])) {
                    count++;
                }
            }
            System.out.println(count);
        } catch (FileNotFoundException e) {
        }
    }
}
