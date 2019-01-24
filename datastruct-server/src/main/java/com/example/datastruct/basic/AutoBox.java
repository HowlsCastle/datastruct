package com.example.datastruct.basic;

public class AutoBox {
    /**
     *
     * java提供了基础类型和包装类型，两种类型会自动相互转化，封箱和拆箱
     *
     * 基础类型转包装类型时会调用valueOf()，以int和Integer为例
     *
     * 包装类型转基础类型时，调用相应的 类型Value()函数
     *
     * 整型装箱过程中调用的函数是
     * public static Integer valueOf(int i) {
     *     if (i >= IntegerCache.low && i <= IntegerCache.high)
     *         return IntegerCache.cache[i + (-IntegerCache.low)];
     *     return new Integer(i);
     * }
     *
     * 上边的函数表示数字在-128到127之间返回的是同一个对象，超过这个直接返回一个新的对对象
     *
     *
     */

    public static void main() {
        Integer integer = 10;//valueOf()装箱
        int i = integer;//拆箱  intValue（）方法
        int i1 = (int) integer;//显示拆箱

        //超过了150返回一个新对象，new Integer
        Integer a = 100, b = 100, c = 150, d = 150;
        System.out.println(a == b);
        System.out.println(c == d);
    }
}
