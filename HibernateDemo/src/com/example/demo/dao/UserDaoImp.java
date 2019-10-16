package com.example.demo.dao;

import com.example.demo.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

public class UserDaoImp extends HibernateDaoSupport implements UserDao {

    @Override
    public User get(Integer id) {
        return getHibernateTemplate().get(User.class, id);
    }

    public List<User> findByPage(String hql, int offset, int pageSize){

        List<User> list = getHibernateTemplate().execute(new HibernateCallback<List<User>>() {
            @Override
            public List<User> doInHibernate(Session session) throws HibernateException {
                List<User> result = session.createQuery(hql).setFirstResult(offset).setMaxResults(pageSize).list();
                return result;
            }
        });

        return list;
    }
}
