/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.portal.servlets;

import com.job.portal.manager.JobApplicationsManager;
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
public class JobApplicationsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        JSONObject obj = null;
        JSONArray arr = null;
        JobApplicationsManager jam = new JobApplicationsManager();
        try {
            String param = request.getParameter("param");
            if (param != null) {
                if (param.equalsIgnoreCase("apply")) {
                    obj = jam.apply(request);
                    out.print(obj);
                } else if (param.equalsIgnoreCase("showApplied")) {
                    arr = jam.getAppliedJobs(request);
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
