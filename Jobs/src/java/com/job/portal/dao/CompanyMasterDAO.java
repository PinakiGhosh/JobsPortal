/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.portal.dao;

import com.job.portal.beans.CompanyMaster;
import com.job.portal.utils.AbstractDAO;
import com.job.portal.utils.ConnectionUtils;
import com.job.portal.utils.LogOut;

/**
 *
 * @author pinaki ghosh
 */
public class CompanyMasterDAO extends AbstractDAO<CompanyMaster> {

    public long insertCompany(CompanyMaster cm) {
        return (long) insert(cm);
    }

    @Override
    public CompanyMaster getObjectById(long id) {
        CompanyMaster ud = null;
        try {
            session = new ConnectionUtils().getSession();
            ud = (CompanyMaster) session.get(CompanyMaster.class, id);
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        } finally {
            if (session.isOpen()) {
                session.close();
            }
            return ud;
        }
    }
}
