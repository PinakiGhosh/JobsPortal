package com.job.portal.beans;
// Generated 3 Nov, 2015 12:02:38 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * CompanyMaster generated by hbm2java
 */
@Entity
@Table(name = "company_master", catalog = "job_portal"
)
public class CompanyMaster implements java.io.Serializable {

    private Long companyId;
    private UserDetails userdetails;
    private String about;
    private String address;
    private String companyName;
    private String contactPersonName;
    private String contactPersonNumber;
    private String email;
    private String industry;
    private String phone;
    private String registrationType;
    private boolean shareContactPersonNumber;
    private boolean shareEmail;
    private boolean sharePhone;
    private String size;
    private byte[] userId;
    private String website;
    private Set<JobMaster> jobmasters = new HashSet<JobMaster>(0);

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "companyID", unique = true, nullable = false)
    public Long getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "addedBy", nullable = false)
    public UserDetails getUserdetails() {
        return this.userdetails;
    }

    public void setUserdetails(UserDetails userdetails) {
        this.userdetails = userdetails;
    }

    @Column(name = "about")
    public String getAbout() {
        return this.about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Column(name = "address")
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "companyName")
    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Column(name = "contactPersonName")
    public String getContactPersonName() {
        return this.contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    @Column(name = "contactPersonNumber")
    public String getContactPersonNumber() {
        return this.contactPersonNumber;
    }

    public void setContactPersonNumber(String contactPersonNumber) {
        this.contactPersonNumber = contactPersonNumber;
    }

    @Column(name = "email")
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "industry")
    public String getIndustry() {
        return this.industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @Column(name = "phone")
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "registrationType")
    public String getRegistrationType() {
        return this.registrationType;
    }

    public void setRegistrationType(String registrationType) {
        this.registrationType = registrationType;
    }

    @Column(name = "shareContactPersonNumber", nullable = false)
    public boolean isShareContactPersonNumber() {
        return this.shareContactPersonNumber;
    }

    public void setShareContactPersonNumber(boolean shareContactPersonNumber) {
        this.shareContactPersonNumber = shareContactPersonNumber;
    }

    @Column(name = "shareEmail", nullable = false)
    public boolean isShareEmail() {
        return this.shareEmail;
    }

    public void setShareEmail(boolean shareEmail) {
        this.shareEmail = shareEmail;
    }

    @Column(name = "sharePhone", nullable = false)
    public boolean isSharePhone() {
        return this.sharePhone;
    }

    public void setSharePhone(boolean sharePhone) {
        this.sharePhone = sharePhone;
    }

    @Column(name = "size")
    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Column(name = "userId")
    public byte[] getUserId() {
        return this.userId;
    }

    public void setUserId(byte[] userId) {
        this.userId = userId;
    }

    @Column(name = "website")
    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "companymaster")
    public Set<JobMaster> getJobmasters() {
        return this.jobmasters;
    }

    public void setJobmasters(Set<JobMaster> jobmasters) {
        this.jobmasters = jobmasters;
    }

}