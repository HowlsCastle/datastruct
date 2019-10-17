package com.example.datastruct.string;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmail {

    public int uniqueEmail(String[] emails) {

        HashSet<String> unique = new HashSet<>();
        for(String email : emails) {
            String[] arr = email.split("@");
            if (arr.length != 2) continue;
            StringBuffer buffer = new StringBuffer();
            for(char c : arr[0].toCharArray()) {
                if (c == '+') break;
                if (c != '.' && c != '+') {
                    buffer.append(c);
                }
            }
            buffer.append("@");
            buffer.append(arr[1]);

            unique.add(buffer.toString());
        }

        return unique.size();
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            String localName = email.split("@")[0];
            String domainName = email.split("@")[1];

            localName = localName.replace(".", "");
            int idx = localName.indexOf('+');
            if (idx != -1) {
                localName = localName.substring(0, idx);
            }

            set.add(localName+"@"+domainName);
        }

        return set.size();
    }
}
