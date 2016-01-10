package com.alkemann.advent.eight;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void testHowManyExtraCharacters() throws Exception {
        List<String> list = new ArrayList<String>();
        list.add("\"\"");
        list.add("\"abc\"");
        list.add("\"aaa\\\"aaa\"");
        list.add("\"\\x27\"");
        Book book = new Book(list);
        System.out.println(book.list);

        assertEquals(23, book.character_count_literal);
        assertEquals(11, book.character_count_for_values);
        assertEquals(12, book.howManyExtraCharacters());
    }
}