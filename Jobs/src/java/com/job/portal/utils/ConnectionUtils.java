/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.portal.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author pinaki ghosh
 */
public class ConnectionUtils {

    private static SessionFactory sessionFactory = null;
    private Session session;

    public static void initSessionFactory() {
        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    }

    public Session getSession() {
        if (sessionFactory == null) {
            initSessionFactory();
        }
        session = sessionFactory.openSession();
        return session;
    }

    public static void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
