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

/**
 *
 * @author pinaki ghosh
 */
public class UserDetailsDAO extends AbstractDAO<UserDetails> {

    public UserDetails insertUser(UserDetails ud) {
        UserDetails u = insert(ud);
        return u;
    }

    public boolean checkCredentials(String email, String pwd) {
        boolean flag = false;
        String actPwd = null;
        try {
            String salt = getSalt(email);
            byte hashArr[] = HashingUtils.getHash(pwd, HashingUtils.base64ToByte(salt));
            String hash = HashingUtils.byteToBase64(hashArr);
//            Document doc = mc.find(eq("_id", email)).first();
//            if (doc != null) {
//                actPwd = doc.getString("pwd");
//                flag = actPwd.equalsIgnoreCase(hash);
//            }
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        }
        return flag;
    }

    public boolean checkEmailExists(String email) {
        boolean flag = false;
        try {
//            Map<String, Object> m = new HashMap<String, Object>();
//            m.put("email", email);
//            JSONArray obj = getObjectList(m);
//            System.out.println(obj);
//            if (obj.length() == 1) {
//                flag = true;
//            }
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        }
        return flag;
    }

    public boolean checkPhoneExists(String phone) {
        boolean flag = false;
        try {
//            Document doc = mc.find(eq("phone", phone)).first();
//            if (doc != null) {
//                flag = true;
//            }
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        }
        return flag;
    }

    public String getSalt(String email) {
        String salt = null;
        try {
//            Document doc = mc.find(eq("_id", email)).first();
//            if (doc != null) {
//                salt = doc.getString("salt");
//            }
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        }
        return salt;
    }
}
