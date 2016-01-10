package com.alkemann.advent.eight;

import java.util.List;

public class Book {

    int character_count_literal = 0;
    int character_count_for_values = 0;
    List<String> list;

    public Book(List<String> list) {
        this.list = list;
        this.calculateCounts();
    }

    private void calculateCounts() {
        for (String s : list) {
            character_count_literal += s.length();

            // Deal with \\ and \"
            s = s.replaceAll("\\\\\\\\", "T"); // removes \\ by replacing with a single character
            s = s.replaceAll("\"", ""); // removes the leading and ending " and converts all \" to \
            s = s.replaceAll("\\\\x\\d\\d", "T"); // replaces \x23 with a single character
            character_count_for_values += s.length(); // having removed two of the escapes we add the rst
        }
    }

    public int howManyExtraCharacters() {
        return character_count_literal - character_count_for_values;
    }
}
