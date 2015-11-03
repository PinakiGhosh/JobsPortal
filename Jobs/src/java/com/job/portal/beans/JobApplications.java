package com.job.portal.beans;
// Generated 3 Nov, 2015 12:02:38 AM by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * JobApplications generated by hbm2java
 */
@Entity
@Table(name = "job_applications", catalog = "job_portal"
)
public class JobApplications implements java.io.Serializable {

    private Long jobAppId;
    private JobMaster jobmaster;
    private UserDetails userdetails;
    private Date appliedOn;

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "jobAppId", unique = true, nullable = false)
    public Long getJobAppId() {
        return this.jobAppId;
    }

    public void setJobAppId(Long jobAppId) {
        this.jobAppId = jobAppId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobId", nullable = false)
    public JobMaster getJobmaster() {
        return this.jobmaster;
    }

    public void setJobmaster(JobMaster jobmaster
    ) {
        this.jobmaster = jobmaster;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    public UserDetails getUserdetails() {
        return this.userdetails;
    }

    public void setUserdetails(UserDetails userdetails) {
        this.userdetails = userdetails;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "appliedOn", length = 19)
    public Date getAppliedOn() {
        return this.appliedOn;
    }

    public void setAppliedOn(Date appliedOn) {
        this.appliedOn = appliedOn;
    }

}
