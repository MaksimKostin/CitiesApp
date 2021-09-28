package com.company.dao;

import com.company.model.City;
import com.company.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.postgresql.util.PSQLException;

import javax.persistence.PersistenceException;
import java.util.List;

public class CityDAO {

    public void writeCities(List<City> cities){
        try{
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            for (City city: cities){
                session.save(city);
            }
            transaction.commit();
            session.close();
        }catch (PersistenceException e){
            System.out.println("==========================");
            System.out.println("База данных уже заполнена!");
            System.out.println("==========================");
        }
    }

    public List<City> getCities(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return session.createQuery("select c from City c", City.class)
                .getResultList();
    }
}
