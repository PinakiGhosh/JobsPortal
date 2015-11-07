/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.portal.utils;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author pinaki ghosh
 */
public abstract class AbstractDAO<T> {

    public Session session;
    public Transaction trans;

    public AbstractDAO() {
        session = new ConnectionUtils().getSession();
    }

    public Object insert(T obj) {
        trans = session.beginTransaction();
        Object ret = (T) session.save(obj);
        trans.commit();
        if (session.isOpen()) {
            session.close();
        }
        return ret;
    }

    public abstract T getObjectById(long id);
}
