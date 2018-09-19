package com.example.factory;

import com.example.service.Being;
import com.example.service.Cat;
import com.example.service.Dog;

public class BeingFactory {
    public static Being getBeing(String arg){
        if (arg.equalsIgnoreCase("dog")){
            return new Dog();
        }
        else {
            return new Cat();
        }
    }
}
