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
            character_count_for_values += s.length(); // FIXME calculate rendered length
        }
    }

    public int howManyExtraCharacters() {
        return character_count_literal - character_count_for_values;
    }
}
