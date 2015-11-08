/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.portal.manager;

import com.job.portal.beans.JobMaster;
import com.job.portal.dao.JobApplicationsDAO;
import com.job.portal.dao.JobsDAO;
import com.job.portal.utils.ExpressionCheck;
import com.job.portal.utils.LogOut;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author pinaki ghosh
 */
public class JobsManager {

    JobsDAO jd = new JobsDAO();

    public boolean addJob(HttpServletRequest request) {
        boolean flag = false;
        try {
            JobMaster jMast = new JobMaster();
            jMast.setDatePosted(new Date());
            if (request.getParameter("description") != null) {
                jMast.setDescription(request.getParameter("description"));
            }
            if (request.getParameter("experience") != null) {
                jMast.setExperience(request.getParameter("experience"));
            }
            if (request.getParameter("functionalArea") != null) {
                jMast.setFunctionalArea(request.getParameter("functionalArea"));
            }
            if (request.getParameter("keywords") != null) {
                jMast.setDescription(request.getParameter("keywords"));
            }
            if (request.getParameter("location") != null) {
                jMast.setDescription(request.getParameter("location"));
            }
            if (request.getParameter("qualificationRequired") != null) {
                jMast.setQualificationRequired(request.getParameter("qualificationRequired"));
            }
            if (request.getParameter("salary") != null) {
                jMast.setSalary(request.getParameter("salary"));
            }
            if (request.getParameter("title") != null) {
                jMast.setTitle(request.getParameter("title"));
            }
            if (request.getParameter("vacancy") != null) {
                jMast.setVacancies(request.getParameter("vacancy"));
            }
            if (request.getParameter("companyId") != null) {
                jMast.setCompanymaster(Integer.parseInt(request.getParameter("companyId")));
            }
            flag = jd.addJob(jMast);
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        } finally {
            return flag;
        }
    }

    public JSONObject getJobDetails(HttpServletRequest request) {
        JSONObject obj = null;
        try {
            String jobId = request.getParameter("jobId");
            if (ExpressionCheck.checkNumber(jobId)) {
                obj = jd.getJobDetails(jobId);
            } else {
                obj = new JSONObject();
            }
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        } finally {
            return obj;
        }
    }

    public JSONArray getJobApplicants(HttpServletRequest request) {
        JSONArray arr = null;
        try {
            String jobId = request.getParameter("jobId");
            if (ExpressionCheck.checkNumber(jobId)) {
                JobApplicationsDAO jad = new JobApplicationsDAO();
                arr = jad.getJobApplicants(jobId);
            } else {
                arr = new JSONArray();
            }
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        } finally {
            return arr;
        }
    }

    public JSONArray getAllJobs(HttpServletRequest request) {
        JSONArray arr = null;
        try {
            arr = jd.getAllJobs();
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        } finally {
            return arr;
        }
    }
}
