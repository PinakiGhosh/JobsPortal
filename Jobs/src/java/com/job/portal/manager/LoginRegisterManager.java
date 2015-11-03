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
        try {
            byte saltArr[] = HashingUtils.generateSalt();
            byte pwdArray[] = HashingUtils.getHash(upb.getPwd(), saltArr);
            upb.setSalt(HashingUtils.byteToBase64(saltArr));
            upb.setPwd(HashingUtils.byteToBase64(pwdArray));
            upb.setJoined(new Date());
            ud = new UserDetailsDAO().insertUser(upb);
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        }
        return ud;
    }
}
