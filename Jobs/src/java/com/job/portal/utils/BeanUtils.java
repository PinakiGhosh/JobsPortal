/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.portal.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/**
 *
 * @author pinaki ghosh
 */
public class BeanUtils {

    public static Map<String, Object> convertToMap(Object bean) {
        Map<String, Object> m = new HashMap<String, Object>();
        try {
            for (Field field : bean.getClass().getDeclaredFields()) {
                field.setAccessible(true); // You might want to set modifier to public first.
                Object value = field.get(bean);
                if (value != null) {
                    m.put(field.getName(), value);
                }
            }
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        }
        return m;
    }

    public static JSONObject convertToJSON(Object bean) {
        JSONObject obj = new JSONObject();
        try {
            for (Field field : bean.getClass().getDeclaredFields()) {
                field.setAccessible(true); // You might want to set modifier to public first.
                Object value = field.get(bean);
                if (value != null) {
                    obj.put(field.getName(), value);
                }
            }
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        }
        return obj;
    }
}
