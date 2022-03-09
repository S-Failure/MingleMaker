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
@Table(name = "appsettings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appsettings.findAll", query = "SELECT a FROM Appsettings a"),
    @NamedQuery(name = "Appsettings.findByAppSettingId", query = "SELECT a FROM Appsettings a WHERE a.appSettingId = :appSettingId"),
    @NamedQuery(name = "Appsettings.findByAppKey", query = "SELECT a FROM Appsettings a WHERE a.appKey = :appKey"),
    @NamedQuery(name = "Appsettings.findByAppValue", query = "SELECT a FROM Appsettings a WHERE a.appValue = :appValue"),
    @NamedQuery(name = "Appsettings.findByCreationDate", query = "SELECT a FROM Appsettings a WHERE a.creationDate = :creationDate")})
public class Appsettings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AppSettingId")
    private Integer appSettingId;
    @Size(max = 100)
    @Column(name = "AppKey")
    private String appKey;
    @Size(max = 1000)
    @Column(name = "AppValue")
    private String appValue;
    @Column(name = "CreationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    public Appsettings() {
    }

    public Appsettings(Integer appSettingId) {
        this.appSettingId = appSettingId;
    }

    public Integer getAppSettingId() {
        return appSettingId;
    }

    public void setAppSettingId(Integer appSettingId) {
        this.appSettingId = appSettingId;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppValue() {
        return appValue;
    }

    public void setAppValue(String appValue) {
        this.appValue = appValue;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appSettingId != null ? appSettingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appsettings)) {
            return false;
        }
        Appsettings other = (Appsettings) object;
        if ((this.appSettingId == null && other.appSettingId != null) || (this.appSettingId != null && !this.appSettingId.equals(other.appSettingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Appsettings[ appSettingId=" + appSettingId + " ]";
    }

}
