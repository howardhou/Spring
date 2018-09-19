package com.example.factory;

import com.example.service.American;
import com.example.service.Chinese;
import com.example.service.Person;

public class PersonFactory {
    public Person getPerson(String arg){
        if (arg.equalsIgnoreCase("chinese")){
            return new Chinese();
        }
        else {
            return new American();
        }
    }
}
