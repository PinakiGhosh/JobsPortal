package com.job.portal.beans;
// Generated 3 Nov, 2015 12:02:38 AM by Hibernate Tools 4.3.1

import java.util.Date;

public class JobApplications implements java.io.Serializable {

    private long jobAppId;
    private long jobId;
    private long userId;
    private Date appliedOn;

    public Long getJobAppId() {
        return this.jobAppId;
    }

    public void setJobAppId(Long jobAppId) {
        this.jobAppId = jobAppId;
    }

    public long getJobmaster() {
        return this.jobId;
    }

    public void setJobmaster(long jobmaster
    ) {
        this.jobId = jobmaster;
    }

    public long getUserdetails() {
        return this.userId;
    }

    public void setUserdetails(long userdetails) {
        this.userId = userdetails;
    }

    public Date getAppliedOn() {
        return this.appliedOn;
    }

    public void setAppliedOn(Date appliedOn) {
        this.appliedOn = appliedOn;
    }

}
