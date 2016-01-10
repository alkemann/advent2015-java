package com.alkemann.advent.five;

public class Present {

    private final String word;

    public Present(String word) {
        this.word = word;
    }

    boolean isNice() {
        return hasVowels() && hasRecurring() && hasNoBadParts();
    }

    boolean hasVowels() {
        int min = 3, counter = 0;
        for (Character ch : word.toCharArray()) {
            switch (ch) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    counter++;
                    break;
            }
            if (counter >= min) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings({"BoxedValueEquality", "NumberEquality"})
    boolean hasRecurring() {
        Character prev = ' ';
        for (Character ch : word.toCharArray()) {
            if (prev == ch) {
                return true;
            }
            prev = ch;
        }
        return false;
    }

    boolean hasNoBadParts() {
        String[] badWords = {"ab", "cd", "pq", "xy"};
        for (String bad : badWords) {
            if (word.contains(bad)) {
                return false;
            }
        }
        return true;
    }
}
