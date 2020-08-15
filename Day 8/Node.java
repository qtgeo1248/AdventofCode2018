import java.util.*;
import java.io.*;

public class Node { //courtesty of Kiran Vuksanaj
    private Node[] children;
    private int[] meta;

    public Node(Scanner in) {
        children = new Node[in.nextInt()];
        meta = new int[in.nextInt()];
        for (int idx = 0; idx < children.length; idx++) {
            children[idx] = new Node(in);
        }
        for (int idx = 0; idx < meta.length; idx++) {
            meta[idx] = in.nextInt();
        }
    }

    public int getMetaSum() {
        int result = 0;
        for (int idx = 0; idx < children.length; idx++) {
            result += children[idx].getMetaSum();
        }
        for (int idx = 0; idx < meta.length; idx++) {
            result += meta[idx];
        }
        return result;
    }

    public int getValue() {
        int result = 0;
        if (children.length == 0) {
            return getMetaSum();
        }
        for (int idx = 0; idx < meta.length; idx++) {
            if (meta[idx] - 1 < children.length) {
                result += children[meta[idx] - 1].getValue();
            }
        }
        return result;
    }
}
