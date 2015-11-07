/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.portal.dao;

import com.job.portal.beans.UserDetails;
import com.job.portal.utils.AbstractDAO;
import com.job.portal.utils.ConnectionUtils;
import com.job.portal.utils.HashingUtils;
import com.job.portal.utils.LogOut;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author pinaki ghosh
 */
public class UserDetailsDAO extends AbstractDAO<UserDetails> {

    public Long insertUser(UserDetails ud) {
        long u = (Long) insert(ud);
        return u;
    }

    @Override
    public UserDetails getObjectById(long id) {
        UserDetails ud = null;
        try {
            session = new ConnectionUtils().getSession();
            ud = (UserDetails) session.get(UserDetails.class, id);
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        } finally {
            if (session.isOpen()) {
                session.close();
            }
            return ud;
        }
    }

    public UserDetails checkCredentials(String email, String pwd) {
        UserDetails ud = null;
        try {
            String salt = getSalt(email);
            byte hashArr[] = HashingUtils.getHash(pwd, HashingUtils.base64ToByte(salt));
            String hash = HashingUtils.byteToBase64(hashArr);
            session = new ConnectionUtils().getSession();
            String hql = "from UserDetails U where U.email= :email and U.pwdHash= :pwd";
            Query query = session.createQuery(hql);
            query.setParameter("email", email);
            query.setParameter("pwd", hash);
            System.out.println("Hash is " + hash + "\t" + hash.equalsIgnoreCase("Xy3a2HcVqDg="));
            ud = (UserDetails) query.uniqueResult();
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        } finally {
            if (session.isOpen()) {
                session.close();
            }
            return ud;
        }
    }

    public boolean checkEmailExists(String email) {
        boolean flag = false;
        List l = null;
        try {
            String hql = "from UserDetails U where U.email= :email";
            session = new ConnectionUtils().getSession();
            Query query = session.createQuery(hql);
            query.setParameter("email", email);
            l = query.list();
            if (l.size() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        } finally {
            if (session.isOpen()) {
                session.close();
            }
            return flag;
        }

    }

    public boolean checkPhoneExists(String phone) {
        boolean flag = false;
        List l = null;
        try {
            session = new ConnectionUtils().getSession();
            String hql = "from UserDetails U where U.phone= :phone";
            Query query = session.createQuery(hql);
            query.setParameter("phone", phone);
            l = query.list();
            if (l.size() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        } finally {
            if (session.isOpen()) {
                session.close();
            }
            return flag;
        }
    }

    public String getSalt(String email) {
        String salt = null;
        UserDetails ud = null;
        try {
            String hql = "from UserDetails U where U.email= :email";
            session = new ConnectionUtils().getSession();
            Query query = session.createQuery(hql);
            query.setParameter("email", email);
            ud = (UserDetails) query.uniqueResult();
            salt = ud.getSalt();
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        } finally {
            if (session.isOpen()) {
                session.close();
            }
            return salt;
        }
    }

    public static void main(String[] args) {
        UserDetailsDAO udd = new UserDetailsDAO();
        String email = "pinaki_ghosh1990@yahoo.com", pwd = "12345";
        System.out.println(udd.getSalt(email));
        System.out.println(udd.checkEmailExists(email));
        System.out.println(udd.checkCredentials(email, pwd));
        ConnectionUtils.closeSessionFactory();

    }
}
