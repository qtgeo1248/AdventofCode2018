import java.util.*;

public class Step {

    char first;
    char next;

    public Step(char a, char b) {
        first = a;
        next = b;
    }

    public char getFirst() {
        return first;
    }

    public char getNext() {
        return next;
    }

    public boolean canBeDone(ArrayList<Character> done, char step) {
        if (!done.contains(first) && step == next) {
            return false;
        }
        return true;
    }
}
