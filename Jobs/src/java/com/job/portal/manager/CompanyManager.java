/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.portal.manager;

import com.job.portal.beans.CompanyMaster;
import com.job.portal.utils.LogOut;
import java.util.Map;

/**
 *
 * @author pinaki ghosh
 */
public class CompanyManager {

    public void addCompany(Map<String, String[]> m) {
        try {
            CompanyMaster cm = new CompanyMaster();
            String key, value;
            for (Map.Entry<String, String[]> e : m.entrySet()) {
                key = e.getKey();
                value = e.getValue()[0];
            }
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        }
    }

}
