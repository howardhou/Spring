package com.example.util;

public class ValueGenerator {
    public int getAge(){
        return 8;
    }

    public static int getStaticAge(){
        return 13;
    }

    public static String getProperty(String key){
        System.out.println("system property: "+ System.getProperties());

        return System.getProperties().getProperty(key);
    }
}
