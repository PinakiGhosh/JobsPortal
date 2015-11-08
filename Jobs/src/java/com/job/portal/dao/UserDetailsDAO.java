/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.portal.dao;

import com.job.portal.beans.UserDetails;
import com.job.portal.utils.AbstractDAO;
import com.job.portal.utils.DbConnection;
import com.job.portal.utils.HashingUtils;
import com.job.portal.utils.LogOut;
import org.json.JSONObject;

/**
 *
 * @author pinaki ghosh
 */
public class UserDetailsDAO extends AbstractDAO {

    public long insertUser(UserDetails ud) {
        long id = -1;
        try {
            String query = "insert into user_details (email,name,pwdHash,salt,joined,phone) values(?,?,?,?,?,?)";
            Object arr[] = new Object[6];
            arr[0] = ud.getEmail();
            arr[1] = ud.getName();
            arr[2] = ud.getPwdHash();
            arr[3] = ud.getSalt();
            arr[4] = ud.getJoined();
            arr[5] = ud.getPhone();
            id = insert(query, arr);
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        } finally {
            return id;
        }
    }

    public JSONObject getUserById(long id) {
        JSONObject ud = null;
        try {
            String query = "select userId,dob,email,gender,joined,name,"
                    + "phone,pwdHash,role,salt "
                    + "from user_details where userId=?";
            Object arr[] = new Object[1];
            arr[0] = id;
            ud = fetchOne(query, arr);
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        } finally {
            return ud;
        }
    }

    public JSONObject checkCredentials(String email, String pwd) {
        JSONObject obj = null;
        System.out.println(email + "\t" + pwd);
        try {
            String salt = getSalt(email);
            byte hashArr[] = HashingUtils.getHash(pwd, HashingUtils.base64ToByte(salt));
            String hash = HashingUtils.byteToBase64(hashArr);
            String query = "select userId,dob,email,gender,joined,name,"
                    + " phone,pwdHash,role,salt"
                    + " from user_details where email=? and pwdHash=?";
            Object arr[] = new Object[2];
            arr[0] = email;
            arr[1] = hash;
            obj = fetchOne(query, arr);
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        } finally {
            return obj;
        }
    }

    public boolean checkEmailExists(String email) {
        boolean flag = false;
        try {
            String query = "select email from user_details where email=?";
            Object arr[] = {email};
            JSONObject obj = fetchOne(query, arr);
            flag = obj == null ? false : true;
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        } finally {
            return flag;
        }

    }

    public boolean checkPhoneExists(String phone) {
        boolean flag = false;
        try {
            String query = "select email from user_details where phone=?";
            Object arr[] = {phone};
            JSONObject obj = fetchOne(query, arr);
            flag = obj == null ? false : true;
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        } finally {
            return flag;
        }
    }

    public String getSalt(String email) {
        String salt = null;
        try {
            String sql = "select salt from user_details where email=?";
            Object arr[] = {email};
            JSONObject obj = fetchOne(sql, arr);
            if (obj.has("salt")) {
                salt = obj.getString("salt");
            }
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        } finally {
            return salt;
        }
    }

    public static void main(String[] args) {
        UserDetailsDAO udd = new UserDetailsDAO();
        String email = "pinaki_ghosh1990@yahoo.com", pwd = "12345";
        System.out.println(udd.getSalt(email));
        System.out.println(udd.checkEmailExists(email));
        System.out.println(udd.checkCredentials(email, pwd));
        new DbConnection().closePool();
    }
}
