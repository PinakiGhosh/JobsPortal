/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.portal.dao;

import com.job.portal.beans.CompanyMaster;
import com.job.portal.utils.AbstractDAO;

/**
 *
 * @author pinaki ghosh
 */
public class CompanyMasterDAO extends AbstractDAO<CompanyMaster> {

    public CompanyMaster insertCompany(CompanyMaster cm) {
        return insert(cm);
    }
}
