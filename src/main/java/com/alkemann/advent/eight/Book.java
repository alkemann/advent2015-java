package com.alkemann.advent.eight;

import java.util.List;

public class Book {

    int character_count_literal = 0;
    int character_count_for_values = 0;
    int character_count_encoded = 0;
    List<String> list;

    public Book(List<String> list) {
        this.list = list;
        this.calculateCounts();
    }

    private void calculateCounts() {
        String encoded, stripped;
        for (String s : list) {
            character_count_literal += s.length();
            stripped = s;
            stripped = stripped.replaceAll("(^\"|\"$)", ""); // escape leading and ending " by converting to ##
            stripped = stripped.replaceAll("\\\\\\\\", "#"); // removes \\ by replacing with a single character
            stripped = stripped.replaceAll("\\\\\"", "#"); // converts all \" to #
            stripped = stripped.replaceAll("\\\\x[\\da-fA-F]{2}", "#"); // replaces \x23 with a single character
            character_count_for_values += stripped.length(); // having removed two of the escapes we add the rst

            encoded = s;
            encoded = encoded.replaceAll("(^\"|\"$)", "#\""); // escape leading and ending " by converting to ##
            encoded = encoded.replaceAll("\\\\\"", "####"); // replace \" with \\\" by replacing \" with ####
            encoded = encoded.replaceAll("\\\\", "##"); // replace \ with \\\ but using ###
            encoded = "\"" + encoded + "\"";
            character_count_encoded += encoded.length();
//            System.out.println("["+s+"]["+s.length()+"] ["+stripped+"]["+stripped.length()+"] ["+encoded+"]["+encoded.length()+"]");
//            System.out.println(character_count_literal +" "+ character_count_for_values +" "+ character_count_encoded);
        }
    }

    public int howManyExtraCharacters() {
        return character_count_literal - character_count_for_values;
    }

    public int howManyExtraEncoded() {
        return character_count_encoded - character_count_literal;
    }
}
