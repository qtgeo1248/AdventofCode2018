import java.util.*;
import java.io.*;

public class Day4a {
    public static void main(String[] args) {
        try {
            File f = new File("Day4Times.txt");
            Scanner in1 = new Scanner(f);
            Day[][] calendar = new Day[12][31];
            int[] sleepAmounts = new int[4000];
            for (int i = 0; i < calendar.length; i++) {
                for (int j = 0; j < calendar[i].length; j++) {
                    calendar[i][j] = new Day(i + 1, j + 1);
                }
            }
            while (in1.hasNext()) {
                String line = in1.nextLine();
                int month = Integer.parseInt(line.substring(line.indexOf("-") + 1, line.indexOf("-") + 3));
                int day = Integer.parseInt(line.substring(line.indexOf("-") + 4, line.indexOf("-") + 6));
                if (line.charAt(19) == 'w') {
                    int time = Integer.parseInt(line.substring(line.indexOf(":") + 1, line.indexOf(":") + 3));
                    calendar[month - 1][day - 1].setAwake(time);
                } else if (line.charAt(19) == 'f') {
                    int time = Integer.parseInt(line.substring(line.indexOf(":") + 1, line.indexOf(":") + 3));
                    calendar[month - 1][day - 1].setSleep(time);
                } else if (line.charAt(19) == 'G') {
                    int id = Integer.parseInt(line.substring(line.indexOf("#") + 1, line.indexOf("b") - 1));
                    int hour = Integer.parseInt(line.substring(line.indexOf(":") - 2, line.indexOf(":")));
                    if (hour != 0) {
                        if (day < 28) {
                            day++;
                        } else {
                            if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day == 31) {
                                if (day == 31) {
                                    month++;
                                    day = 1;
                                }
                            } else if ((month == 4 || month == 6 || month == 9 || month == 11) && day == 30) {
                                if (day == 30) {
                                    month ++;
                                    day = 1;
                                }
                            } else if ((month == 2) && day == 28) {
                                if (day == 28) {
                                    month++;
                                    day = 1;
                                }
                            }
                            else {
                                day++;
                            }
                        }
                    }
                    calendar[month - 1][day - 1].setID(id);
                }
            }
            for (int i = 0; i < calendar.length; i++) {
                for (int j = 0; j < calendar[i].length; j++) {
                    calendar[i][j].calibrate();
                    sleepAmounts[calendar[i][j].getID()] += calendar[i][j].returnSum();
                }
            }
            int greatestID = -1;
            int greatestSleep = -1;
            for (int i = 0; i < sleepAmounts.length; i++) {
                if (sleepAmounts[i] > greatestSleep) {
                    greatestSleep = sleepAmounts[i];
                    greatestID = i;
                }
            }
            int[] min = new int[60];
            for (int i = 0; i < calendar.length; i++) {
                for (int j = 0; j < calendar[i].length; j++) {
                    if (calendar[i][j].getID() == greatestID) {
                        for (int idx = 0; idx < 60; idx++) {
                            if (calendar[i][j].getSchedule()[idx] == 1) {
                                min[idx]++;
                            }
                        }
                    }
                }
            }
            int bigMin = -1;
            int bigSleep = -1;
            for (int i = 0; i < 60; i++) {
                if (min[i] > bigSleep) {
                    bigSleep = min[i];
                    bigMin = i;
                }
            }
            System.out.println(greatestID);
            System.out.println(bigMin);

        } catch (FileNotFoundException e) {
        }
    }
}
