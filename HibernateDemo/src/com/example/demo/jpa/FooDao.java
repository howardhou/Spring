package com.example.demo.jpa;

import org.springframework.stereotype.Repository;

@Repository
public class FooDao extends JpaBaseDao<Foo>  implements IFooDao{

    // 实体Class在构造函数中传递
    public FooDao(){
        setClazz(Foo.class );
    }
}
