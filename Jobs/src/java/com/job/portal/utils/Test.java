/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.portal.utils;

import com.job.portal.beans_my.UserDetailsBean;
import com.job.portal.enums.Gender;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author pinaki ghosh
 */
public class Test {

    public static void main(String[] args) {
        UserDetailsBean ud = new UserDetailsBean();
        ud.setGender(Gender.Male);
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            //session.save(ud);
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
            sessionFactory.close();
        }

    }
}
