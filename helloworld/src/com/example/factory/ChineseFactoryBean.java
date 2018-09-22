package com.example.factory;

import com.example.service.Chinese;
import com.example.service.Person;
import org.springframework.beans.factory.FactoryBean;

public class ChineseFactoryBean implements FactoryBean<Person> {
    Person p = null;

    @Override
    public Person getObject() throws Exception {
        if (p == null){
            p = new Chinese();
        }

        return p;
    }

    @Override
    public Class<? extends Person> getObjectType() {
        return Chinese.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
