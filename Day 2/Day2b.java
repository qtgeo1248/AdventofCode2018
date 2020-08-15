import java.util.*;
import java.io.*;

public class Day2b {
    public static void main(String[] args) {
        try {
            File f = new File("Day2BoxID.txt");
            Scanner in = new Scanner(f);
            ArrayList<String> boxid= new ArrayList<String>();
            while (in.hasNext()) {
                boxid.add(in.next());
            }
            for (int i = 0; i < boxid.size(); i++) {
                for (int j = i + 1; j < boxid.size(); j++) {
                    int difs = 0;
                    for (int idx = 0; idx < boxid.get(i).length(); idx++) {
                        if (boxid.get(i).charAt(idx) != boxid.get(j).charAt(idx)) {
                            difs++;
                        }
                    }
                    if (difs == 1) {
                        System.out.println(boxid.get(i));
                        System.out.println(boxid.get(j));
                    }
                }
            }
        }
        catch (FileNotFoundException e){
        }
    }
}
