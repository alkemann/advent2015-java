package com.alkemann.advent.six;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grid {

    private final Pattern pattern;
    private int[][] map = new int[1000][1000];
    private final boolean toggleOverride;

    public Grid(boolean toggleOverride) {
        this.toggleOverride = toggleOverride;
        pattern = Pattern.compile("^([\\w\\s]+) (\\d{1,3}),(\\d{1,3}) through (\\d{1,3}),(\\d{1,3})$");
    }

    public Grid() {
//        for (int x = 0; x < 1000; x++)
//            for (int y = 0; y < 1000; y++) {
//                map[x][y] = false;
//            }
        toggleOverride = false;
        pattern = Pattern.compile("^([\\w\\s]+) (\\d{1,3}),(\\d{1,3}) through (\\d{1,3}),(\\d{1,3})$");
    }

    /*
    toggle 393,804 through 510,976
    turn off 6,964 through 411,976
    turn off 33,572 through 978,590
    turn on 579,693 through 650,978
    */
    public void handleCommand(String s) throws UnknownError {
        Matcher m = pattern.matcher(s);
        if (m.matches()) {
            String command = m.group(1);
            int x1 = Integer.parseInt(m.group(2));
            int y1 = Integer.parseInt(m.group(3));
            int x2 = Integer.parseInt(m.group(4));
            int y2 = Integer.parseInt(m.group(5));
//            System.out.println(command +" "+ x1 +","+ y1 +" to "+ x2 +","+y2);

            switch (command) {
                case "turn on":
                    turnOn(x1, y1, x2, y2);
                    break;
                case "turn off":
                    turnOff(x1, y1, x2, y2);
                    break;
                case "toggle":
                    toggle(x1, y1, x2, y2);
                    break;
                default:
                    System.out.println("ERROR: unknown command: [" + command + "]");
                    throw new UnknownError();
            }
        } else {
            System.out.println("ERROR: Unparsed command string: [" + s + "]");
        }
    }

    public boolean isOn(int x, int y) throws IndexOutOfBoundsException {
        if (x < 0 || x > 999 || y < 0 || y > 999) throw new IndexOutOfBoundsException();
        return map[x][y] > 0;
    }

    public void turnOn(int x1, int y1, int x2, int y2) throws IndexOutOfBoundsException {
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                turnOn(x, y);
            }
        }
    }

    public void turnOn(int x, int y) throws IndexOutOfBoundsException {
        if (x < 0 || x > 999 || y < 0 || y > 999) throw new IndexOutOfBoundsException();
        map[x][y] += 1;
    }

    public void turnOff(int x1, int y1, int x2, int y2) throws IndexOutOfBoundsException {
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                turnOff(x, y);
            }
        }
    }

    public void turnOff(int x, int y) throws IndexOutOfBoundsException {
        if (x < 0 || x > 999 || y < 0 || y > 999) throw new IndexOutOfBoundsException();
        map[x][y] -= 1;
        if (map[x][y] < 0) map[x][y] = 0;
    }


    public void toggle(int x1, int y1, int x2, int y2) throws IndexOutOfBoundsException {
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                toggle(x, y);
            }
        }
    }

    public void toggle(int x, int y) throws IndexOutOfBoundsException {
        if (x < 0 || x > 999 || y < 0 || y > 999) throw new IndexOutOfBoundsException();
        if (toggleOverride) {
            map[x][y] += 2;
        } else {
            map[x][y] = map[x][y] == 0 ? 1 : 0;
        }
    }

    public int howManyIsOn() {
        int count = 0;
        for (int x = 0; x < 1000; x++) {
            for (int y = 0; y < 1000; y++) {
                count += map[x][y] == 0 ? 0 : 1;
            }
        }
        return count;
    }

    public int howBrightIs(int x, int y) {
        return map[x][y];
    }

    public int brightness() {
        int brightness = 0;
        for (int x = 0; x < 1000; x++) {
            for (int y = 0; y < 1000; y++) {
                brightness += map[x][y];
            }
        }
        return brightness;
    }
}
