/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.portal.servlets;

import com.job.portal.beans.CompanyMaster;
import com.job.portal.beans.UserDetails;
import com.job.portal.manager.CompanyManager;
import com.job.portal.utils.LogOut;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author pinaki ghosh
 */
public class CompanyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        JSONObject obj = new JSONObject();
        JSONArray arr = null;
        String param = null;
        Map<String, String[]> m = request.getParameterMap();
        CompanyManager cm = new CompanyManager();
        HttpSession sess = request.getSession(false);
        UserDetails ud = (UserDetails) sess.getAttribute("user");
        CompanyMaster cMaster = null;
        try {
            obj.put("status", false);
            if (request.getParameter("param") != null) {
                param = request.getParameter("param");
                if (param.equalsIgnoreCase("addCompany")) {
                    cMaster = cm.addCompany(m, ud);
                    if (cMaster != null && cMaster.getCompanyId() > 0) {
                        obj.put("status", true);
                        obj.put("msg", "Company added");
                    } else {
                        obj.put("msg", "There seems to be some problem try again later");
                    }
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
