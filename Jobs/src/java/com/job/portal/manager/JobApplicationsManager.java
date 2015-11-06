/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.portal.manager;

import com.job.portal.beans.JobApplications;
import com.job.portal.beans.UserDetails;
import com.job.portal.utils.BeanUtils;
import com.job.portal.utils.LogOut;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author pinaki ghosh
 */
public class JobApplicationsManager {

    public JSONArray getJobsPosted(UserDetails ud) {
        JSONArray arr = new JSONArray();
        JSONObject obj = null;
        try {
            Set<JobApplications> ja = ud.getJobapplicationses();
            for (JobApplications j : ja) {
                obj = BeanUtils.convertToJSON(j);
                arr.put(obj);
            }
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        } finally {
            return arr;
        }
    }
}
