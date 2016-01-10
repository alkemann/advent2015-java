package com.alkemann.advent.five;

public class PresentTwo {

    private final String word;

    public PresentTwo(String word) {
        this.word = word;
    }

    boolean isNice() {
        return hasDoubleLetter() && hasRecurring();
    }

    @SuppressWarnings({"BoxedValueEuality", "NumberEquality"})
    boolean hasRecurring() {
        String pair, rest;
        int startAt = 0;

        while (startAt < word.length() - 3) {
            pair = word.substring(startAt, startAt + 2);
            rest = word.substring(startAt + 2);
            if (lookFor(pair, rest)) {
                return true;
            }
            startAt++;
        }

        return false;
    }

    boolean lookFor(String pair, String rest) {
//        System.out.println("Looking for " + pair + " in " + rest);
        return rest.contains(pair);
    }

    boolean hasDoubleLetter() {
        int startAt = 0;
        while (startAt < word.length() - 2) {
            char a = word.charAt(startAt), b = word.charAt(startAt+2);
//            System.out.println("Looking for " + a + " in " + b);
            if (a == b) return true;
            startAt++;
        }
        return false;
    }
}
