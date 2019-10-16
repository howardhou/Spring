package com.example.demo.dao;

import com.example.demo.entity.Person;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

public class PersonDaoImp implements PersonDao {
    
    private HibernateTemplate ht  = null;

    private SessionFactory sessionFactory;

    // 依赖注入
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public HibernateTemplate getHibernateTemplate() {
        if (ht == null){
            ht = new HibernateTemplate(this.sessionFactory);
        }

        return ht;
    }

    public Person get(Integer id) {
        return getHibernateTemplate().get(Person.class, id);
    }
}
