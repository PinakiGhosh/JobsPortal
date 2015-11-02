package com.job.portal.beans;
// Generated 3 Nov, 2015 12:02:38 AM by Hibernate Tools 4.3.1


import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Jobmaster generated by hbm2java
 */
@Entity
@Table(name="jobmaster"
    ,catalog="job_portal"
)
public class Jobmaster  implements java.io.Serializable {


     private Long jobId;
     private Companymaster companymaster;
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
     private Set<Jobapplications> jobapplicationses = new HashSet<Jobapplications>(0);

    public Jobmaster() {
    }

	
    public Jobmaster(Companymaster companymaster, Date datePosted, String vacancies) {
        this.companymaster = companymaster;
        this.datePosted = datePosted;
        this.vacancies = vacancies;
    }
    public Jobmaster(Companymaster companymaster, Date datePosted, String description, String experience, String functionalArea, String keywords, String location, String qualificationRequired, String salary, String title, String vacancies, Set<Jobapplications> jobapplicationses) {
       this.companymaster = companymaster;
       this.datePosted = datePosted;
       this.description = description;
       this.experience = experience;
       this.functionalArea = functionalArea;
       this.keywords = keywords;
       this.location = location;
       this.qualificationRequired = qualificationRequired;
       this.salary = salary;
       this.title = title;
       this.vacancies = vacancies;
       this.jobapplicationses = jobapplicationses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="jobId", unique=true, nullable=false)
    public Long getJobId() {
        return this.jobId;
    }
    
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="companyId", nullable=false)
    public Companymaster getCompanymaster() {
        return this.companymaster;
    }
    
    public void setCompanymaster(Companymaster companymaster) {
        this.companymaster = companymaster;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="datePosted", nullable=false, length=19)
    public Date getDatePosted() {
        return this.datePosted;
    }
    
    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    
    @Column(name="description")
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name="experience")
    public String getExperience() {
        return this.experience;
    }
    
    public void setExperience(String experience) {
        this.experience = experience;
    }

    
    @Column(name="functionalArea")
    public String getFunctionalArea() {
        return this.functionalArea;
    }
    
    public void setFunctionalArea(String functionalArea) {
        this.functionalArea = functionalArea;
    }

    
    @Column(name="keywords")
    public String getKeywords() {
        return this.keywords;
    }
    
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    
    @Column(name="location")
    public String getLocation() {
        return this.location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }

    
    @Column(name="qualificationRequired")
    public String getQualificationRequired() {
        return this.qualificationRequired;
    }
    
    public void setQualificationRequired(String qualificationRequired) {
        this.qualificationRequired = qualificationRequired;
    }

    
    @Column(name="salary")
    public String getSalary() {
        return this.salary;
    }
    
    public void setSalary(String salary) {
        this.salary = salary;
    }

    
    @Column(name="title")
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    
    @Column(name="vacancies", nullable=false)
    public String getVacancies() {
        return this.vacancies;
    }
    
    public void setVacancies(String vacancies) {
        this.vacancies = vacancies;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="jobmaster")
    public Set<Jobapplications> getJobapplicationses() {
        return this.jobapplicationses;
    }
    
    public void setJobapplicationses(Set<Jobapplications> jobapplicationses) {
        this.jobapplicationses = jobapplicationses;
    }




}

