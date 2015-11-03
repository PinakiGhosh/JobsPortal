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

    Session session;
    Transaction trans;

    public AbstractDAO() {
        session = new ConnectionUtils().getSession();
    }

    public T insert(T obj) {
        trans = session.beginTransaction();
        T ret = (T) session.save(obj);
        trans.commit();
        session.close();
        return ret;
    }
}
