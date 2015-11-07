/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.portal.manager;

import com.job.portal.beans.UserDetails;
import com.job.portal.dao.UserDetailsDAO;
import com.job.portal.utils.HashingUtils;
import com.job.portal.utils.LogOut;
import java.util.Date;

/**
 *
 * @author pinaki ghosh
 */
public class LoginRegisterManager {

    public UserDetails registerUser(UserDetails upb) {
        UserDetails ud = null;
        UserDetailsDAO udd = new UserDetailsDAO();
        try {
            byte saltArr[] = HashingUtils.generateSalt();
            byte pwdArray[] = HashingUtils.getHash(upb.getPwd(), saltArr);
            upb.setSalt(HashingUtils.byteToBase64(saltArr));
            upb.setPwdHash(HashingUtils.byteToBase64(pwdArray));
            upb.setJoined(new Date());
            long uId = udd.insertUser(upb);
            ud = udd.getObjectById(uId);
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        }
        return ud;
    }

    public static void main(String[] args) {
        try {
            String pwd = "12345";
            byte saltArr[] = HashingUtils.generateSalt();
            byte pwdArray[] = HashingUtils.getHash(pwd, saltArr);
            String hash = HashingUtils.byteToBase64(pwdArray);
            String salt = HashingUtils.byteToBase64(saltArr);
            System.out.println(hash + "\t" + salt);
            saltArr = HashingUtils.base64ToByte(salt);
            pwdArray = HashingUtils.getHash(pwd, saltArr);
            String pwd1 = HashingUtils.byteToBase64(pwdArray);
            System.out.println(pwd1);
            System.out.println(pwd1.equalsIgnoreCase(hash));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
