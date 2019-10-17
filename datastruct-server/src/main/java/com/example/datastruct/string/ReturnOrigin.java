package com.example.datastruct.string;

public class ReturnOrigin {

    public boolean returnOrigin(String moves) {
        int horiziontal = 0;
        int vertical = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U':
                    vertical++;
                    break;
                case 'D':
                    vertical--;
                    break;
                case 'R':
                    horiziontal++;
                    break;
                case 'L':
                    horiziontal--;
                    break;
            }
        }

        return horiziontal == 0 && vertical == 0;
    }
}
