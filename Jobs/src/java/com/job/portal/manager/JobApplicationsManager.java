/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.portal.manager;

import com.job.portal.dao.JobApplicationsDAO;
import com.job.portal.utils.ExpressionCheck;
import com.job.portal.utils.LogOut;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author pinaki ghosh
 */
public class JobApplicationsManager {

    public JSONObject apply(HttpServletRequest request) {
        JSONObject obj = new JSONObject(), obj1 = null;
        boolean flag = false;
        JobApplicationsDAO jad = new JobApplicationsDAO();
        try {
            obj.put("status", flag);
            HttpSession sess = request.getSession(false);
            obj1 = (JSONObject) sess.getAttribute("user");
            String jobId = request.getParameter("jobId");
            if (jobId != null && ExpressionCheck.checkNumber(jobId)) {
                if (obj1.has("userId")) {
                    flag = jad.applyForJob(jobId, obj1.getString("userId"));
                    obj.put("status", flag);
                    if (flag) {
                        obj.put("msg", "Successfully Applied");
                    } else {
                        obj.put("msg", "There seems to be some problem please try again after sometime");
                    }
                } else {
                    obj.put("msg", "Please log in to continue");
                }
            } else {
                obj.put("msg", "Invalid job id");
            }
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        } finally {
            return obj;
        }
    }

    public JSONArray getAppliedJobs(HttpServletRequest request) {
        JSONArray arr = new JSONArray();
        JSONObject obj = null;
        JobApplicationsDAO jad = new JobApplicationsDAO();
        try {
            HttpSession sess = request.getSession(false);
            obj = (JSONObject) sess.getAttribute("user");
            if (obj.has("userId")) {
                arr = jad.getAppliedJobs(obj.getString("userId"));
            } else {
                obj.put("msg", "Please log in to continue");
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
