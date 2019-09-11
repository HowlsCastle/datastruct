package com.example.datastruct.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectTest {


    public static void main(String[] args) {
        Class mSonClass = SonClass.class;

        Field[] fields = mSonClass.getFields();
        for(Field field : fields) {
            int modifiers = field.getModifiers();
            System.out.print(Modifier.toString(modifiers) + " ");
            //输出变量的类型及变量名
            System.out.println(field.getType().getName()
                    + " " + field.getName());
        }
    }
}
