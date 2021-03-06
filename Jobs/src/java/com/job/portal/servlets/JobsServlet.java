/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.portal.servlets;

import com.job.portal.manager.JobsManager;
import com.job.portal.utils.LogOut;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author pinaki ghosh
 */
public class JobsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        JSONObject obj = null;
        JSONArray arr = null;
        try {
            String param = request.getParameter("param");
            JobsManager jm = new JobsManager();
            if (param != null) {
                if (param.equalsIgnoreCase("addJob")) {
                    boolean flag = jm.addJob(request);
                    obj = new JSONObject();
                    obj.put("status", flag);
                    if (flag) {
                        obj.put("msg", "Job created successfully");
                    } else {
                        obj.put("msg", "Please try again after sometime");
                    }
                    out.print(obj);
                } else if (param.equalsIgnoreCase("getJobDetails")) {
                    obj = jm.getJobDetails(request);
                    out.print(obj);
                } else if (param.equalsIgnoreCase("getJobApplicants")) {
                    arr = jm.getJobApplicants(request);
                    out.print(arr);
                } else if (param.equalsIgnoreCase("showAll")) {
                    arr = jm.getAllJobs(request);
                    out.print(arr);
                }
            }
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        } finally {
            out.close();
        }
    }

}
