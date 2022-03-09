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
@Table(name = "marriagebureos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marriagebureos.findAll", query = "SELECT m FROM Marriagebureos m"),
    @NamedQuery(name = "Marriagebureos.findByBureoId", query = "SELECT m FROM Marriagebureos m WHERE m.bureoId = :bureoId"),
    @NamedQuery(name = "Marriagebureos.findByUserId", query = "SELECT m FROM Marriagebureos m WHERE m.userId = :userId"),
    @NamedQuery(name = "Marriagebureos.findByBureoName", query = "SELECT m FROM Marriagebureos m WHERE m.bureoName = :bureoName"),
    @NamedQuery(name = "Marriagebureos.findByBureoAddress", query = "SELECT m FROM Marriagebureos m WHERE m.bureoAddress = :bureoAddress"),
    @NamedQuery(name = "Marriagebureos.findByContactEmail", query = "SELECT m FROM Marriagebureos m WHERE m.contactEmail = :contactEmail"),
    @NamedQuery(name = "Marriagebureos.findByRegNo", query = "SELECT m FROM Marriagebureos m WHERE m.regNo = :regNo"),
    @NamedQuery(name = "Marriagebureos.findByDescription", query = "SELECT m FROM Marriagebureos m WHERE m.description = :description"),
    @NamedQuery(name = "Marriagebureos.findByIsDeleted", query = "SELECT m FROM Marriagebureos m WHERE m.isDeleted = :isDeleted"),
    @NamedQuery(name = "Marriagebureos.findByCreationDate", query = "SELECT m FROM Marriagebureos m WHERE m.creationDate = :creationDate"),
    @NamedQuery(name = "Marriagebureos.findByModificationDate", query = "SELECT m FROM Marriagebureos m WHERE m.modificationDate = :modificationDate")})
public class Marriagebureos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BureoId")
    private Integer bureoId;
    @Column(name = "UserId")
    private Integer userId;
    @Size(max = 250)
    @Column(name = "BureoName")
    private String bureoName;
    @Size(max = 250)
    @Column(name = "BureoAddress")
    private String bureoAddress;
    @Size(max = 250)
    @Column(name = "ContactEmail")
    private String contactEmail;
    @Size(max = 20)
    @Column(name = "RegNo")
    private String regNo;
    @Size(max = 1000)
    @Column(name = "Description")
    private String description;
    @Column(name = "IsDeleted")
    private Boolean isDeleted;
    @Column(name = "CreationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "ModificationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;

    public Marriagebureos() {
    }

    public Marriagebureos(Integer bureoId) {
        this.bureoId = bureoId;
    }

    public Integer getBureoId() {
        return bureoId;
    }

    public void setBureoId(Integer bureoId) {
        this.bureoId = bureoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBureoName() {
        return bureoName;
    }

    public void setBureoName(String bureoName) {
        this.bureoName = bureoName;
    }

    public String getBureoAddress() {
        return bureoAddress;
    }

    public void setBureoAddress(String bureoAddress) {
        this.bureoAddress = bureoAddress;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
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
        hash += (bureoId != null ? bureoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marriagebureos)) {
            return false;
        }
        Marriagebureos other = (Marriagebureos) object;
        if ((this.bureoId == null && other.bureoId != null) || (this.bureoId != null && !this.bureoId.equals(other.bureoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Marriagebureos[ bureoId=" + bureoId + " ]";
    }

}
