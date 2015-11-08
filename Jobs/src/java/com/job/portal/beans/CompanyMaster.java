package com.job.portal.beans;
// Generated 3 Nov, 2015 12:02:38 AM by Hibernate Tools 4.3.1

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
    private String website;
    private long userId;

    public Long getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public UserDetails getUserdetails() {
        return this.userdetails;
    }

    public void setUserdetails(UserDetails userdetails) {
        this.userdetails = userdetails;
    }

    public String getAbout() {
        return this.about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactPersonName() {
        return this.contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getContactPersonNumber() {
        return this.contactPersonNumber;
    }

    public void setContactPersonNumber(String contactPersonNumber) {
        this.contactPersonNumber = contactPersonNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIndustry() {
        return this.industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegistrationType() {
        return this.registrationType;
    }

    public void setRegistrationType(String registrationType) {
        this.registrationType = registrationType;
    }

    public boolean isShareContactPersonNumber() {
        return this.shareContactPersonNumber;
    }

    public void setShareContactPersonNumber(boolean shareContactPersonNumber) {
        this.shareContactPersonNumber = shareContactPersonNumber;
    }

    public boolean isShareEmail() {
        return this.shareEmail;
    }

    public void setShareEmail(boolean shareEmail) {
        this.shareEmail = shareEmail;
    }

    public boolean isSharePhone() {
        return this.sharePhone;
    }

    public void setSharePhone(boolean sharePhone) {
        this.sharePhone = sharePhone;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

}
