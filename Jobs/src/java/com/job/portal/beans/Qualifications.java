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
 * Qualifications generated by hbm2java
 */
@Entity
@Table(name = "qualifications", catalog = "job_portal"
)
public class Qualifications implements java.io.Serializable {

    private Integer qid;
    private UserDetails userdetails;
    private String qualification;
    private Date lastUsed;
    private String skillLevel;

    public Qualifications() {
    }

    public Qualifications(UserDetails userdetails, String qualification, Date lastUsed, String skillLevel) {
        this.userdetails = userdetails;
        this.qualification = qualification;
        this.lastUsed = lastUsed;
        this.skillLevel = skillLevel;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "qId", unique = true, nullable = false)
    public Integer getQid() {
        return this.qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    public UserDetails getUserdetails() {
        return this.userdetails;
    }

    public void setUserdetails(UserDetails userdetails) {
        this.userdetails = userdetails;
    }

    @Column(name = "qualification", nullable = false, length = 45)
    public String getQualification() {
        return this.qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "lastUsed", nullable = false, length = 10)
    public Date getLastUsed() {
        return this.lastUsed;
    }

    public void setLastUsed(Date lastUsed) {
        this.lastUsed = lastUsed;
    }

    @Column(name = "skillLevel", nullable = false, length = 12)
    public String getSkillLevel() {
        return this.skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

}
