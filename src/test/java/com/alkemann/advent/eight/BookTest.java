package com.alkemann.advent.eight;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void testHowManyExtraCharacters() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("\"\"");
        list.add("\"abc\"");
        list.add("\"aaa\\\"aaa\"");
        list.add("\"\\x27\"");
        list.add("\"b\\\\b\"");
        list.add("\"\\xg7\\xa7\\x27\""); // "\xg7\xa7\x27" > \xg7TT

        Book book = new Book(list);
        int expected_literals = 2 + 5 + 10 + 6 + 6 + 14;
        assertEquals("Wrong literals", expected_literals, book.character_count_literal);
        int expected_valued = /*0 + */ 3 + 7 + 1 + 3 + 6;
        assertEquals("Wrong valued", expected_valued, book.character_count_for_values);
        assertEquals("Wrong extra", expected_literals - expected_valued, book.howManyExtraCharacters());
    }
}