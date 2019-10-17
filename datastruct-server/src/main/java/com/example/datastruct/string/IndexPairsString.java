package com.example.datastruct.string;

import java.util.ArrayList;
import java.util.List;

public class IndexPairsString {
    public static List<List<Integer>> indexPairs(String str, String[] words) {

        List<List<Integer>> ret = new ArrayList<>();
        for(String w : words) {
            int index = 0;
            while (true) {
                if ((index = str.indexOf(w, index)) != -1) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(index);
                    tmp.add(index+w.length()-1);

                    ret.add(tmp);
                    index += 1;
                } else {
                    break;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String str = "thestoryofleetcodeandme";
        String[] words = {"story","fleet","leetcode"};

        System.out.println(indexPairs(str, words));
    }
}
