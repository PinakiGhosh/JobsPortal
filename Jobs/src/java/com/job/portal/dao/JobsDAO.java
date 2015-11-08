/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.portal.dao;

import com.job.portal.beans.JobMaster;
import com.job.portal.utils.AbstractDAO;
import com.job.portal.utils.LogOut;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author pinaki ghosh
 */
public class JobsDAO extends AbstractDAO {

    public boolean addJob(JobMaster jm) {
        boolean flag = false;
        try {
            String query = "insert into job_master (datePosted,description,experience,"
                    + "functionalArea,keywords,location,qualificationRequired,salary,title,vacancies,companyId) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?)";
            Object[] arr = new Object[11];
            arr[0] = new Date();
            arr[1] = jm.getDescription();
            arr[2] = jm.getExperience();
            arr[3] = jm.getFunctionalArea();
            arr[4] = jm.getKeywords();
            arr[5] = jm.getLocation();
            arr[6] = jm.getQualificationRequired();
            arr[7] = jm.getSalary();
            arr[8] = jm.getTitle();
            arr[9] = jm.getVacancies();
            arr[10] = jm.getCompanymaster();
            int id = insert(query, arr);
            if (id > -1) {
                flag = true;
            }
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        } finally {
            return flag;
        }
    }

    public JSONObject getJobDetails(String jobId) {
        JSONObject obj = null;
        try {
            String query = "select jm.jobId,jm.datePosted,jm.description,jm.experience,jm.functionalArea,jm.keywords,"
                    + "jm.location,jm.qualificationRequired,jm.salary,jm.title,jm.vacancies,jm.companyId,"
                    + "cm.companyName,ud.`name`,ud.userId "
                    + "from job_master jm join company_master cm "
                    + "on jm.companyId=cm.companyID "
                    + "join user_details ud on "
                    + "ud.userId=cm.userId "
                    + "where jm.jobId=?";
            Object[] arr = new Object[1];
            arr[0] = jobId;
            obj = fetchOne(query, arr);
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        } finally {
            return obj;
        }
    }

    public JSONArray getAllJobs() {
        JSONArray obj = null;
        try {
            String query = "select jm.jobId,jm.datePosted,jm.description,jm.experience,jm.functionalArea,jm.keywords,"
                    + "jm.location,jm.qualificationRequired,jm.salary,jm.title,jm.vacancies,jm.companyId,"
                    + "cm.companyName,ud.`name`,ud.userId "
                    + "from job_master jm join company_master cm "
                    + "on jm.companyId=cm.companyID "
                    + "join user_details ud on "
                    + "ud.userId=cm.userId "
                    + "order by jm.datePosted desc";
            Object[] arr = new Object[0];
            obj = fetchList(query, arr);
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        } finally {
            return obj;
        }
    }
}
