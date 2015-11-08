/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.portal.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author pinaki ghosh
 */
public abstract class AbstractDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public AbstractDAO() {
        con = new DbConnection().getConnection();
    }

    public void closeConnections() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public int insert(String query, Object[] values) throws SQLException {
        int id = -1;
        Object o = null;
        String type = null;
        Date d = null;
        java.util.Date utilDate = null;
        if (con.isClosed()) {
            con = new DbConnection().getConnection();
        }
        ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        for (int i = 0; i < values.length; i++) {
            o = values[i];
            type = o.getClass().toString();
            if (type.contains("String")) {
                ps.setString(i + 1, (String) o);
            } else if (type.contains("Integer")) {
                ps.setInt(i + 1, (Integer) o);
            } else if (type.contains("Long")) {
                ps.setLong(i + 1, (Long) o);
            } else if (type.contains("Date")) {
                utilDate = (java.util.Date) o;
                ps.setDate(i + 1, new Date(utilDate.getTime()));
            }
        }
        id = ps.executeUpdate();
        closeConnections();
        return id;
    }

    public JSONArray fetchList(String query, Object[] values) throws SQLException, JSONException {
        JSONArray arr = new JSONArray();
        Object o = null;
        String type = null;
        if (con.isClosed()) {
            con = new DbConnection().getConnection();
        }
        ps = con.prepareStatement(query);
        for (int i = 0; i < values.length; i++) {
            o = values[i];
            type = o.getClass().toString();
            if (type.contains("String")) {
                ps.setString(i + 1, (String) o);
            } else if (type.contains("Integer")) {
                ps.setInt(i + 1, (Integer) o);
            } else if (type.contains("Long")) {
                ps.setLong(i + 1, (Long) o);
            } else if (type.contains("Date")) {
                ps.setDate(i + 1, (Date) o);
            }
        }
        rs = ps.executeQuery();
        arr = getJSONArray(rs);
        closeConnections();
        return arr;
    }

    public JSONObject fetchOne(String query, Object[] values) throws SQLException, JSONException {
        JSONObject obj = new JSONObject();
        Object o = null;
        String type = null;
        if (con.isClosed()) {
            con = new DbConnection().getConnection();
        }
        ps = con.prepareStatement(query);
        for (int i = 0; i < values.length; i++) {
            o = values[i];
            type = o.getClass().toString();
            if (type.contains("String")) {
                ps.setString(i + 1, (String) o);
            } else if (type.contains("Integer")) {
                ps.setInt(i + 1, (Integer) o);
            } else if (type.contains("Long")) {
                ps.setLong(i + 1, (Long) o);
            } else if (type.contains("Date")) {
                ps.setDate(i + 1, (Date) o);
            }
        }
        rs = ps.executeQuery();
        obj = getJSONObject(rs);
        closeConnections();
        return obj;
    }

    protected JSONArray getJSONArray(ResultSet rs) throws SQLException, JSONException {
        JSONArray arr = new JSONArray();
        JSONObject obj = null;
        ResultSetMetaData rsmd = rs.getMetaData();
        int size = rsmd.getColumnCount();
        while (rs.next()) {
            obj = new JSONObject();
            for (int i = 1; i <= size; i++) {
                obj.put(rsmd.getColumnName(i), rs.getString(i));
            }
            arr.put(obj);
        }
        return arr;
    }

    protected JSONObject getJSONObject(ResultSet rs) throws SQLException, JSONException {
        JSONObject obj = null;
        ResultSetMetaData rsmd = rs.getMetaData();
        int size = rsmd.getColumnCount();
        if (rs.next()) {
            obj = new JSONObject();
            for (int i = 1; i <= size; i++) {
                obj.put(rsmd.getColumnName(i), rs.getString(i));
            }
        }
        return obj;
    }

    public static void main(String[] args) {
        java.util.Date date = new java.util.Date();
        System.out.println(date);
        Date d = new Date(date.getTime());
        System.out.println(d);
    }
}
