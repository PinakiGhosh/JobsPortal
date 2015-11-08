/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.portal.dao;

import com.job.portal.utils.AbstractDAO;
import com.job.portal.utils.LogOut;
import java.util.Date;
import org.json.JSONArray;

/**
 *
 * @author pinaki ghosh
 */
public class JobApplicationsDAO extends AbstractDAO {

    public boolean applyForJob(String jobId, String userId) {
        boolean flag = false;
        try {
            String sql = "insert into job_applications (appliedOn,jobId,userId) "
                    + "values (?,?,?)";
            Object arr[] = new Object[3];
            arr[0] = new Date();
            arr[1] = jobId;
            arr[2] = userId;
            int id = insert(sql, arr);
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

    public JSONArray getAppliedJobs(String userId) {
        JSONArray arr = new JSONArray();
        try {
            String query = "SELECT jm.`jobId`,jm.`datePosted`,jm.`description`,jm.`experience`,jm.`functionalArea`,"
                    + "jm.`keywords`,"
                    + "jm.`location`,jm.`qualificationRequired`,jm.`salary`,jm.`title`,jm.`vacancies`,"
                    + "jm.`companyId`,ja.appliedOn"
                    + "FROM `job_master` jm join job_applications ja on ja.jobId "
                    + "where jm.jobId in ( "
                    + "select jobId from job_applications where userId=?) "
                    + "order by ja.appliedOn desc;";
            Object obj[] = new Object[1];
            obj[0] = userId;
            arr = fetchList(query, obj);
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        } finally {
            return arr;
        }
    }

    public JSONArray getJobApplicants(String jobId) {
        JSONArray arr = new JSONArray();
        try {
            String query = "select ud.userId,ud.`name`,ud.dob,ud.phone,ud.email,ja.appliedOn "
                    + "from user_details ud join job_applications ja "
                    + "on ud.userId=ja.userId "
                    + "where ja.jobId=? "
                    + "order by ja.appliedOn desc; by ja.appliedOn desc;";
            Object obj[] = new Object[1];
            obj[0] = jobId;
            arr = fetchList(query, obj);
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        } finally {
            return arr;
        }
    }
}
