import java.util.*;
import java.io.*;

public class Day8a{
    public static void main(String[] args) { //courtesty of Kiran Vuksanaj
        try {
            File f = new File("Day8Header.txt");
            Scanner in = new Scanner(f);
            Node n = new Node(in);
            System.out.println(n.getMetaSum());
        } catch (FileNotFoundException e) {
        }
    }
}
