/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DevilsScary
 */
@Entity
@Table(name = "userdetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userdetails.findAll", query = "SELECT u FROM Userdetails u"),
    @NamedQuery(name = "Userdetails.findByUserDetailId", query = "SELECT u FROM Userdetails u WHERE u.userDetailId = :userDetailId"),
    @NamedQuery(name = "Userdetails.findByUserId", query = "SELECT u FROM Userdetails u WHERE u.userId = :userId"),
    @NamedQuery(name = "Userdetails.findByBureoId", query = "SELECT u FROM Userdetails u WHERE u.bureoId = :bureoId"),
    @NamedQuery(name = "Userdetails.findByEyeColour", query = "SELECT u FROM Userdetails u WHERE u.eyeColour = :eyeColour"),
    @NamedQuery(name = "Userdetails.findByHairColour", query = "SELECT u FROM Userdetails u WHERE u.hairColour = :hairColour"),
    @NamedQuery(name = "Userdetails.findByHeight", query = "SELECT u FROM Userdetails u WHERE u.height = :height"),
    @NamedQuery(name = "Userdetails.findByEducation", query = "SELECT u FROM Userdetails u WHERE u.education = :education"),
    @NamedQuery(name = "Userdetails.findByMeritalStatus", query = "SELECT u FROM Userdetails u WHERE u.meritalStatus = :meritalStatus"),
    @NamedQuery(name = "Userdetails.findByMotherTongue", query = "SELECT u FROM Userdetails u WHERE u.motherTongue = :motherTongue"),
    @NamedQuery(name = "Userdetails.findByRequiredChild", query = "SELECT u FROM Userdetails u WHERE u.requiredChild = :requiredChild"),
    @NamedQuery(name = "Userdetails.findByLookingFor", query = "SELECT u FROM Userdetails u WHERE u.lookingFor = :lookingFor"),
    @NamedQuery(name = "Userdetails.findByAddress", query = "SELECT u FROM Userdetails u WHERE u.address = :address"),
    @NamedQuery(name = "Userdetails.findBySalary", query = "SELECT u FROM Userdetails u WHERE u.salary = :salary"),
    @NamedQuery(name = "Userdetails.findByOccupation", query = "SELECT u FROM Userdetails u WHERE u.occupation = :occupation"),
    @NamedQuery(name = "Userdetails.findByWorkAddress", query = "SELECT u FROM Userdetails u WHERE u.workAddress = :workAddress"),
    @NamedQuery(name = "Userdetails.findByCreationdate", query = "SELECT u FROM Userdetails u WHERE u.creationdate = :creationdate"),
    @NamedQuery(name = "Userdetails.findByModificationdate", query = "SELECT u FROM Userdetails u WHERE u.modificationdate = :modificationdate")})
public class Userdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UserDetailId")
    private Integer userDetailId;
    @Column(name = "UserId")
    private Integer userId;
    @Column(name = "BureoId")
    private Integer bureoId;
    @Size(max = 50)
    @Column(name = "EyeColour")
    private String eyeColour;
    @Size(max = 50)
    @Column(name = "HairColour")
    private String hairColour;
    @Size(max = 50)
    @Column(name = "Height")
    private String height;
    @Size(max = 50)
    @Column(name = "Education")
    private String education;
    @Size(max = 50)
    @Column(name = "MeritalStatus")
    private String meritalStatus;
    @Size(max = 50)
    @Column(name = "MotherTongue")
    private String motherTongue;
    @Column(name = "RequiredChild")
    private Boolean requiredChild;
    @Size(max = 50)
    @Column(name = "LookingFor")
    private String lookingFor;
    @Size(max = 250)
    @Column(name = "Address")
    private String address;
    @Size(max = 250)
    @Column(name = "Salary")
    private String salary;
    @Size(max = 250)
    @Column(name = "Occupation")
    private String occupation;
    @Size(max = 250)
    @Column(name = "WorkAddress")
    private String workAddress;
    @Column(name = "Creationdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Column(name = "Modificationdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationdate;

    public Userdetails() {
    }

    public Userdetails(Integer userDetailId) {
        this.userDetailId = userDetailId;
    }

    public Integer getUserDetailId() {
        return userDetailId;
    }

    public void setUserDetailId(Integer userDetailId) {
        this.userDetailId = userDetailId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBureoId() {
        return bureoId;
    }

    public void setBureoId(Integer bureoId) {
        this.bureoId = bureoId;
    }

    public String getEyeColour() {
        return eyeColour;
    }

    public void setEyeColour(String eyeColour) {
        this.eyeColour = eyeColour;
    }

    public String getHairColour() {
        return hairColour;
    }

    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMeritalStatus() {
        return meritalStatus;
    }

    public void setMeritalStatus(String meritalStatus) {
        this.meritalStatus = meritalStatus;
    }

    public String getMotherTongue() {
        return motherTongue;
    }

    public void setMotherTongue(String motherTongue) {
        this.motherTongue = motherTongue;
    }

    public Boolean getRequiredChild() {
        return requiredChild;
    }

    public void setRequiredChild(Boolean requiredChild) {
        this.requiredChild = requiredChild;
    }

    public String getLookingFor() {
        return lookingFor;
    }

    public void setLookingFor(String lookingFor) {
        this.lookingFor = lookingFor;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Date getModificationdate() {
        return modificationdate;
    }

    public void setModificationdate(Date modificationdate) {
        this.modificationdate = modificationdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userDetailId != null ? userDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userdetails)) {
            return false;
        }
        Userdetails other = (Userdetails) object;
        if ((this.userDetailId == null && other.userDetailId != null) || (this.userDetailId != null && !this.userDetailId.equals(other.userDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Userdetails[ userDetailId=" + userDetailId + " ]";
    }

}
