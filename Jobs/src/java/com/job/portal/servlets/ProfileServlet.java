/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.portal.servlets;

import com.job.portal.beans.UserDetails;
import com.job.portal.utils.LogOut;
import java.io.IOException;
import java.io.PrintWriter;
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
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        JSONObject obj = null;
        JSONArray arr = null;
        try {
            String param = request.getParameter("param");
            HttpSession sess = request.getSession(false);
            UserDetails ud = (UserDetails) sess.getAttribute("user");
            if (param != null) {
                if (param.equalsIgnoreCase("getProfile")) {

                } else if (param.equalsIgnoreCase("getPostedJobs")) {
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
