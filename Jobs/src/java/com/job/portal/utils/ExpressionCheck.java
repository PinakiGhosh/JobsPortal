/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.portal.utils;

/**
 *
 * @author 711638
 */
public class ExpressionCheck {

    public static boolean checkEmail(String email) {
        String pattern = "^[\\w\\+]+(\\.[\\w]+)*@"
                + "[\\w]+(\\.[\\w]+)*(\\.[A-Za-z]{2,})$";
        if (email == null) {
            return false;
        } else {
            return email.matches(pattern);
        }
    }

    public static boolean checkPhone(String phone) {
        String pattern = "^\\d{10,12}$";
        if (phone == null) {
            return false;
        } else {
            return phone.matches(pattern);
        }
    }

    public static boolean checkPincode(String pincode) {
        String pattern = "^\\d{6}$";
        if (pincode == null) {
            return false;
        } else {
            return pincode.matches(pattern);
        }
    }

    public static boolean checkString(String str) {
        String pattern = "^\\p{L}+(?: \\p{L}+)*$";
        if (str == null) {
            return false;
        } else {
            return str.matches(pattern);
        }
    }

    public static boolean checkNumber(String phone) {
        String pattern = "([\\d.]+)";
        if (phone == null) {
            return false;
        } else {
            return phone.matches(pattern);
        }
    }

    public static boolean checkDate(String date) {
        String arr[] = date.split("/");
        if (arr.length < 3) {
            return false;
        }
        int day = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int year = Integer.parseInt(arr[2]);
        if (day >= 0 && day <= 31) {
            if (month >= 0 && month <= 12) {
                if (year > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String checkFilePath(String path) {
        if (path.contains("\\\\") || path.contains("/")) {
            path = path.replaceAll("/", "_");
            path = path.replaceAll("\\\\", "_");
        }
        if (path.contains(":")) {
            path = path.replaceAll(":", "_");
        }
        return path;
    }

    public static boolean checkPassword(String pwd) {
        boolean flag = false;
        flag = (pwd != null) && (pwd.length() > 2);
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(checkNumber("517"));
    }
}
