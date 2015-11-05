/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.portal.dao;

import com.job.portal.beans.UserDetails;
import com.job.portal.utils.AbstractDAO;
import com.job.portal.utils.HashingUtils;
import com.job.portal.utils.LogOut;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author pinaki ghosh
 */
public class UserDetailsDAO extends AbstractDAO<UserDetails> {

    public UserDetails insertUser(UserDetails ud) {
        UserDetails u = insert(ud);
        return u;
    }

    public UserDetails checkCredentials(String email, String pwd) {
        UserDetails ud = null;
        try {
            String salt = getSalt(email);
            byte hashArr[] = HashingUtils.getHash(pwd, HashingUtils.base64ToByte(salt));
            String hash = HashingUtils.byteToBase64(hashArr);
            String hql = "from user_details where user_details.email= :email and user_details.pwdHash= :pwd";
            Query query = session.createQuery(hql);
            query.setParameter("email", email);
            query.setParameter("pwd", hash);
            ud = (UserDetails) query.uniqueResult();
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        }
        return ud;
    }

    public boolean checkEmailExists(String email) {
        boolean flag = false;
        List l = null;
        try {
            String hql = "from user_details where user_details.email= :email";
            Query query = session.createQuery(hql);
            query.setParameter("phone", email);
            l = query.list();
            if (l.size() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        }
        return flag;
    }

    public boolean checkPhoneExists(String phone) {
        boolean flag = false;
        List l = null;
        try {
            String hql = "from user_details where user_details.phone= :phone";
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
        }
        return flag;
    }

    public String getSalt(String email) {
        String salt = null;
        UserDetails ud = null;
        try {
            String hql = "from user_details where user_details.email= :email";
            Query query = session.createQuery(hql);
            query.setParameter("email", email);
            ud = (UserDetails) query.uniqueResult();
            salt = ud.getSalt();
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        }
        return salt;
    }

    public static void main(String[] args) {

    }
}
