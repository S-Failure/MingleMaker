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
@Table(name = "countries")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Countries.findAll", query = "SELECT c FROM Countries c"),
    @NamedQuery(name = "Countries.findByCountryId", query = "SELECT c FROM Countries c WHERE c.countryId = :countryId"),
    @NamedQuery(name = "Countries.findByCountryName", query = "SELECT c FROM Countries c WHERE c.countryName = :countryName"),
    @NamedQuery(name = "Countries.findByCountryCode", query = "SELECT c FROM Countries c WHERE c.countryCode = :countryCode"),
    @NamedQuery(name = "Countries.findByIsDeleted", query = "SELECT c FROM Countries c WHERE c.isDeleted = :isDeleted"),
    @NamedQuery(name = "Countries.findByCreationDate", query = "SELECT c FROM Countries c WHERE c.creationDate = :creationDate"),
    @NamedQuery(name = "Countries.findByModificationDate", query = "SELECT c FROM Countries c WHERE c.modificationDate = :modificationDate")})
public class Countries implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CountryId")
    private Integer countryId;
    @Size(max = 50)
    @Column(name = "CountryName")
    private String countryName;
    @Size(max = 50)
    @Column(name = "CountryCode")
    private String countryCode;
    @Column(name = "IsDeleted")
    private Boolean isDeleted;
    @Column(name = "CreationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "ModificationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;

    public Countries() {
    }

    public Countries(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
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
        hash += (countryId != null ? countryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Countries)) {
            return false;
        }
        Countries other = (Countries) object;
        if ((this.countryId == null && other.countryId != null) || (this.countryId != null && !this.countryId.equals(other.countryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Countries[ countryId=" + countryId + " ]";
    }

}
