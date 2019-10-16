package com.example.demo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

public class JpaBaseDao<T extends Serializable> {

        // 实体Class在子类的构造函数中赋值
        private Class<T> clazz;

        // 由PersistenceAnnotationBeanPostProcessor后处理器处理，从Spring容器中检索JPA实体管理器并注入它
        @PersistenceContext
        EntityManager entityManager;

        public final void setClazz( Class< T > clazzToSet ){
            this.clazz = clazzToSet;
        }

        public T findOne( long id ){
            return entityManager.find( clazz, id );
        }
        public List< T > findAll(){
            return entityManager.createQuery( "from " + clazz.getName() ).getResultList();
        }

        public void create( T entity ){
            entityManager.persist( entity );
        }

        public T update( T entity ){
            return entityManager.merge( entity );
        }

        public void delete( T entity ){
            entityManager.remove( entity );
        }
        public void deleteById( long entityId ){
            T entity = findOne( entityId );
            delete( entity );
        }

}
