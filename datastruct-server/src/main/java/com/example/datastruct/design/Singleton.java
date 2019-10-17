package com.example.datastruct.design;

public class Singleton {
    private static Singleton instance;

    /**
     * 双重检测模式
     * @return
     */
    public static Singleton getInstance() {
        if(instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }


    private static Singleton singleton = new Singleton();
    /**
     * 饿汉模式
     */
    public static Singleton getSingleton1() {
        return singleton;
    }

    /**
     * 静态内部类方式
     *
     * 序列化的方式调用，还是会生成两个不同的对象
     */

    public static class SingletonHolder {
        private static Singleton singleton = new Singleton();
    }

    public static Singleton getSingleton2() {
        return SingletonHolder.singleton;
    }
}
