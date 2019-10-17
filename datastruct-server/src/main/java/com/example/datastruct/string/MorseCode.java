package com.example.datastruct.string;

import java.util.HashSet;

public class MorseCode {

    public int morseCode(String[] strings) {
        String[] MORSE = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."} ;

        HashSet<String> unique = new HashSet<>();
        for(String word : strings) {
            StringBuffer buffer = new StringBuffer();
            for(char c : word.toCharArray()) {
                buffer.append(MORSE[c-'a']);
            }
            unique.add(buffer.toString());
        }

        return unique.size();
    }
}
