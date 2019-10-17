package com.example.datastruct.string;

public class DefangeIp {
    public String defangeIp(String ip) {
        StringBuffer buffer = new StringBuffer();
        for(int i=0; i< ip.length();i++) {
            if (ip.charAt(i) == '.') {
                buffer.append("[.]");
            } else {
                buffer.append(ip.charAt(i));
            }
        }
        return buffer.toString();
    }
}
