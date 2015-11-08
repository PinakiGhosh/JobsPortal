package com.job.portal.beans;
// Generated 3 Nov, 2015 12:02:38 AM by Hibernate Tools 4.3.1

import java.util.Date;

public class JobMaster implements java.io.Serializable {

    private long jobId;
    private long companyId;
    private Date datePosted;
    private String description;
    private String experience;
    private String functionalArea;
    private String keywords;
    private String location;
    private String qualificationRequired;
    private String salary;
    private String title;
    private String vacancies;

    public Long getJobId() {
        return this.jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public long getCompanymaster() {
        return this.companyId;
    }

    public void setCompanymaster(long companymaster) {
        this.companyId = companymaster;
    }

    public Date getDatePosted() {
        return this.datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExperience() {
        return this.experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getFunctionalArea() {
        return this.functionalArea;
    }

    public void setFunctionalArea(String functionalArea) {
        this.functionalArea = functionalArea;
    }

    public String getKeywords() {
        return this.keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getQualificationRequired() {
        return this.qualificationRequired;
    }

    public void setQualificationRequired(String qualificationRequired) {
        this.qualificationRequired = qualificationRequired;
    }

    public String getSalary() {
        return this.salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVacancies() {
        return this.vacancies;
    }

    public void setVacancies(String vacancies) {
        this.vacancies = vacancies;
    }

}
