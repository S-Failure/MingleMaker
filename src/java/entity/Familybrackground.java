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
@Table(name = "familybrackground")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Familybrackground.findAll", query = "SELECT f FROM Familybrackground f"),
    @NamedQuery(name = "Familybrackground.findByFamilyBrackgroundId", query = "SELECT f FROM Familybrackground f WHERE f.familyBrackgroundId = :familyBrackgroundId"),
    @NamedQuery(name = "Familybrackground.findByUserId", query = "SELECT f FROM Familybrackground f WHERE f.userId = :userId"),
    @NamedQuery(name = "Familybrackground.findByBureoId", query = "SELECT f FROM Familybrackground f WHERE f.bureoId = :bureoId"),
    @NamedQuery(name = "Familybrackground.findByFatherName", query = "SELECT f FROM Familybrackground f WHERE f.fatherName = :fatherName"),
    @NamedQuery(name = "Familybrackground.findByFatherOccupation", query = "SELECT f FROM Familybrackground f WHERE f.fatherOccupation = :fatherOccupation"),
    @NamedQuery(name = "Familybrackground.findByMotherName", query = "SELECT f FROM Familybrackground f WHERE f.motherName = :motherName"),
    @NamedQuery(name = "Familybrackground.findBySibilings", query = "SELECT f FROM Familybrackground f WHERE f.sibilings = :sibilings"),
    @NamedQuery(name = "Familybrackground.findByContactNumber", query = "SELECT f FROM Familybrackground f WHERE f.contactNumber = :contactNumber"),
    @NamedQuery(name = "Familybrackground.findByContactEmail", query = "SELECT f FROM Familybrackground f WHERE f.contactEmail = :contactEmail"),
    @NamedQuery(name = "Familybrackground.findByCreationDate", query = "SELECT f FROM Familybrackground f WHERE f.creationDate = :creationDate"),
    @NamedQuery(name = "Familybrackground.findByModificationDate", query = "SELECT f FROM Familybrackground f WHERE f.modificationDate = :modificationDate")})
public class Familybrackground implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FamilyBrackgroundId")
    private Integer familyBrackgroundId;
    @Column(name = "UserId")
    private Integer userId;
    @Column(name = "BureoId")
    private Integer bureoId;
    @Size(max = 250)
    @Column(name = "FatherName")
    private String fatherName;
    @Size(max = 250)
    @Column(name = "FatherOccupation")
    private String fatherOccupation;
    @Size(max = 250)
    @Column(name = "MotherName")
    private String motherName;
    @Column(name = "Sibilings")
    private Integer sibilings;
    @Size(max = 20)
    @Column(name = "ContactNumber")
    private String contactNumber;
    @Size(max = 250)
    @Column(name = "ContactEmail")
    private String contactEmail;
    @Column(name = "CreationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "ModificationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;

    public Familybrackground() {
    }

    public Familybrackground(Integer familyBrackgroundId) {
        this.familyBrackgroundId = familyBrackgroundId;
    }

    public Integer getFamilyBrackgroundId() {
        return familyBrackgroundId;
    }

    public void setFamilyBrackgroundId(Integer familyBrackgroundId) {
        this.familyBrackgroundId = familyBrackgroundId;
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

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFatherOccupation() {
        return fatherOccupation;
    }

    public void setFatherOccupation(String fatherOccupation) {
        this.fatherOccupation = fatherOccupation;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public Integer getSibilings() {
        return sibilings;
    }

    public void setSibilings(Integer sibilings) {
        this.sibilings = sibilings;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (familyBrackgroundId != null ? familyBrackgroundId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Familybrackground)) {
            return false;
        }
        Familybrackground other = (Familybrackground) object;
        if ((this.familyBrackgroundId == null && other.familyBrackgroundId != null) || (this.familyBrackgroundId != null && !this.familyBrackgroundId.equals(other.familyBrackgroundId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Familybrackground[ familyBrackgroundId=" + familyBrackgroundId + " ]";
    }

}
