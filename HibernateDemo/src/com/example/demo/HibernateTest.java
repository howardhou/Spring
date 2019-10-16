package com.example.demo;

import com.example.demo.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
    private static SessionFactory sessionFactory;

    static {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); // 读取指定的主配置文件
        sessionFactory = cfg.buildSessionFactory(); // 根据配置生成Session工厂
    }

    public static void main(String[] args){
        testGet();
    }

    public static void testSave() {
        User user = new User();
        user.setName("张三");

        // 保存
        Session session = sessionFactory.openSession(); // 打开一个新的Session
        Transaction tx = session.beginTransaction(); // 开启事务

        session.save(user);

        tx.commit(); // 提交事务
        session.close(); // 关闭Session，释放资源(不一定是真正的关闭)
    }

    public static void testGet() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        User user = (User) session.get(User.class, 1); // 获取？
        System.out.println(user);

        tx.commit();
        session.close();
    }
}
