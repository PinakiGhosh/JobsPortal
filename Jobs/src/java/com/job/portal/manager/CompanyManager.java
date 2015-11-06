/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.portal.manager;

import com.job.portal.beans.CompanyMaster;
import com.job.portal.beans.UserDetails;
import com.job.portal.utils.LogOut;
import java.util.Map;

/**
 *
 * @author pinaki ghosh
 */
public class CompanyManager {

    public CompanyMaster addCompany(Map<String, String[]> m, UserDetails ud) {
        CompanyMaster cm = new CompanyMaster();
        try {
            String key, value;
            cm.setUserdetails(ud);
            for (Map.Entry<String, String[]> e : m.entrySet()) {
                key = e.getKey();
                value = e.getValue()[0];
                if (key.equalsIgnoreCase("about")) {
                    cm.setAbout(value);
                } else if (key.equalsIgnoreCase("address")) {
                    cm.setAddress(value);
                } else if (key.equalsIgnoreCase("companyName")) {
                    cm.setCompanyName(value);
                } else if (key.equalsIgnoreCase("contactPersonName")) {
                    cm.setContactPersonName(value);
                } else if (key.equalsIgnoreCase("contactPersonNumber")) {
                    cm.setContactPersonNumber(value);
                } else if (key.equalsIgnoreCase("email")) {
                    cm.setEmail(value);
                } else if (key.equalsIgnoreCase("industry")) {
                    cm.setIndustry(value);
                } else if (key.equalsIgnoreCase("phone")) {
                    cm.setPhone(value);
                } else if (key.equalsIgnoreCase("registrationType")) {
                    cm.setRegistrationType(value);
                } else if (key.equalsIgnoreCase("shareContactPersonNumber")) {
                    cm.setShareContactPersonNumber(Boolean.parseBoolean(value));
                } else if (key.equalsIgnoreCase("shareEmail")) {
                    cm.setShareEmail(Boolean.parseBoolean(value));
                } else if (key.equalsIgnoreCase("sharePhone")) {
                    cm.setSharePhone(Boolean.parseBoolean(value));
                } else if (key.equalsIgnoreCase("size")) {
                    cm.setSize(value);
                } else if (key.equalsIgnoreCase("website")) {
                    cm.setWebsite(value);
                }
            }
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        } finally {
            return cm;
        }
    }

}
