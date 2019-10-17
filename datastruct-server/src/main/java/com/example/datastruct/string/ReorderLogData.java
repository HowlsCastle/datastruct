package com.example.datastruct.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReorderLogData {

    public static String[] reorderLogData(String[] logs) {
        List<String> dlog = new ArrayList<>();
        List<String> alog = new ArrayList<>();
        for (String l : logs) {
            int index = l.indexOf(" ");
            char c = l.charAt(index+1);
            if (c>='0' || c <= '9') {
                dlog.add(l);
            } else {
                alog.add(l);
            }
        }

        Collections.sort(alog, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int index1 = s1.indexOf(" ");
                String id1 = s1.substring(0, index1);
                String letter1 = s1.substring(index1+1);

                int index2 = s2.indexOf(" ");
                String id2 = s2.substring(0, index2);
                String letter2 = s2.substring(index2+1);
                int v1 = letter1.compareTo(letter2);
                if(v1 != 0) return v1;
                int v2 = id1.compareTo(id2);
                return v2;
            }
        });

        String[] result = new String[alog.size() + dlog.size()];
        int i = 0;
        for(String s: alog) {
            result[i++] = s;
        }
        for(String s: dlog) {
            result[i++] = s;
        }
        return result;
    }
}
