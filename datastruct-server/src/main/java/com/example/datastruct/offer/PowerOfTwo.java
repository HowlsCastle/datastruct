package com.example.datastruct.offer;

public class PowerOfTwo {
    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     *
     * 判断一个整数是否是2的整数次幂
     * 方法：如果是2的整数次幂，减一和这个数进行与操作得到的结果就是0，如：100 & 011
     */

    public boolean isPowerOfTwo(int n) {

        int ret = n & (n-1);
        if (ret == 0) {
            return true;
        }
        return false;
    }


    /**
     *
     * 求一个数n中1的个数
     *
     */

    public int countNum(int n) {
        int count = 0;
        while(n != 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }

    /**
     *
     * 计算出大于某个值的最小2的次幂
     * >>>1 将高位后的一位变成1
     * >>>2 将高位的4位变成1
     *
     */

    public int powerTwo(int num) {
        int n = num - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public static void main(String[] args) {

        PowerOfTwo powerOfTwo = new PowerOfTwo();
        System.out.println(powerOfTwo.isPowerOfTwo(8));
        System.out.println(powerOfTwo.isPowerOfTwo(7));

        System.out.println(powerOfTwo.countNum(8));
        System.out.println(powerOfTwo.countNum(7));

        System.out.println(powerOfTwo.powerTwo(8));
        System.out.println(powerOfTwo.powerTwo(17));

    }
}
