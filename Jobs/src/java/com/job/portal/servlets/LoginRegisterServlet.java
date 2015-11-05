/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.portal.servlets;

import com.job.portal.beans.UserDetails;
import com.job.portal.dao.UserDetailsDAO;
import com.job.portal.manager.LoginRegisterManager;
import com.job.portal.utils.ExpressionCheck;
import com.job.portal.utils.LogOut;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

/**
 *
 * @author pinaki ghosh
 */
public class LoginRegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        JSONObject obj = null;
        String email = null, pwd = null;
        boolean flag = false;
        UserDetails upb = new UserDetails();
        try {
//            Map<String, String[]> m = request.getParameterMap();
//            for (Map.Entry<String, String[]> e : m.entrySet()) {
//                System.out.println(e.getKey() + "\t" + e.getValue()[0]);
//            }
            if (request.getParameter("param") != null) {
                obj = new JSONObject();
                obj.put("status", false);
                String param = request.getParameter("param");
                if (request.getParameter("email") != null) {
                    email = request.getParameter("email");
                    if (ExpressionCheck.checkEmail(email)) {
                        if (request.getParameter("pwd") != null) {
                            pwd = request.getParameter("pwd");
                            if (!ExpressionCheck.checkPassword(pwd)) {
                                obj.put("msg", "Password should be atleast 3 characters long");
                            }
                        } else {
                            obj.put("msg", "Please provide a password");
                        }
                    } else {
                        obj.put("msg", "Enter proper email");
                    }
                } else {
                    obj.put("msg", "Please provide an email");
                }
                if (!obj.has("msg")) {
                    if (param.equalsIgnoreCase("register")) {
                        String name = null, phone = null, cPwd = null;
                        if (!new UserDetailsDAO().checkEmailExists(email)) {
                            if (request.getParameter("cPwd") != null) {
                                cPwd = request.getParameter("cPwd");
                                if (pwd.equalsIgnoreCase(cPwd)) {
                                    if (request.getParameter("name") != null) {
                                        name = request.getParameter("name");
                                        if (ExpressionCheck.checkString(name)) {
                                            if (request.getParameter("phone") != null) {
                                                phone = request.getParameter("phone");
                                                if (!new UserDetailsDAO().checkPhoneExists(phone)) {
                                                    if (ExpressionCheck.checkPhone(phone)) {
                                                        upb.setEmail(email);
                                                        upb.setName(name);
                                                        upb.setPhone(phone);
                                                        upb.setPwd(pwd);
                                                        UserDetails ud = new LoginRegisterManager().registerUser(upb);
                                                        obj.put("status", ud == null ? false : true);
                                                        if (flag) {
                                                            obj.put("msg", "Registered Successfully");
                                                            HttpSession sess = request.getSession(true);
                                                            sess.setAttribute("user", ud);
                                                        } else {
                                                            obj.put("msg", "Ooops!! Try again later");
                                                        }

                                                    }
                                                } else {
                                                    obj.put("msg", "Already registered with this number");
                                                }
                                            } else {
                                                obj.put("msg", "Enter a proper phone number");
                                            }
                                        }
                                    } else {
                                        obj.put("msg", "Name can have only alphabets");
                                    }
                                } else {
                                    obj.put("msg", "Please provide your name");
                                }
                            } else {
                                obj.put("msg", "Password and confirm password do not match");
                            }
                        }
                    } else {
                        obj.put("msg", "Already registered with this email");
                    }
                } else if (param.equalsIgnoreCase("login")) {
                    UserDetails ud = new UserDetailsDAO().checkCredentials(email, pwd);
                    obj.put("status", ud == null ? false : true);
                    if (flag) {
                        obj.put("msg", "Login Successful");
                        HttpSession sess = request.getSession(true);
                        sess.setAttribute("user", ud);
                    } else {
                        obj.put("msg", "Username and password donot match");
                    }
                }
            }
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        } finally {
            out.print(obj);
            out.close();
        }
    }

}
