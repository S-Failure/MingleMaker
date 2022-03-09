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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DevilsScary
 */
@Entity
@Table(name = "requests")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requests.findAll", query = "SELECT r FROM Requests r"),
    @NamedQuery(name = "Requests.findByRequestId", query = "SELECT r FROM Requests r WHERE r.requestId = :requestId"),
    @NamedQuery(name = "Requests.findByUserFromId", query = "SELECT r FROM Requests r WHERE r.userFromId = :userFromId"),
    @NamedQuery(name = "Requests.findByUserToId", query = "SELECT r FROM Requests r WHERE r.userToId = :userToId"),
    @NamedQuery(name = "Requests.findByBureoFromId", query = "SELECT r FROM Requests r WHERE r.bureoFromId = :bureoFromId"),
    @NamedQuery(name = "Requests.findByBureoToId", query = "SELECT r FROM Requests r WHERE r.bureoToId = :bureoToId"),
    @NamedQuery(name = "Requests.findByStatus", query = "SELECT r FROM Requests r WHERE r.status = :status"),
    @NamedQuery(name = "Requests.findByIsDeleted", query = "SELECT r FROM Requests r WHERE r.isDeleted = :isDeleted"),
    @NamedQuery(name = "Requests.findByCreationDate", query = "SELECT r FROM Requests r WHERE r.creationDate = :creationDate"),
    @NamedQuery(name = "Requests.findByModificationDate", query = "SELECT r FROM Requests r WHERE r.modificationDate = :modificationDate")})
public class Requests implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RequestId")
    private Integer requestId;
    @Column(name = "UserFromId")
    private Integer userFromId;
    @Column(name = "UserToId")
    private Integer userToId;
    @Column(name = "BureoFromId")
    private Integer bureoFromId;
    @Column(name = "BureoToId")
    private Integer bureoToId;
    @Column(name = "Status")
    private Integer status;
    @Column(name = "IsDeleted")
    private Boolean isDeleted;
    @Column(name = "CreationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "ModificationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;

    public Requests() {
    }

    public Requests(Integer requestId) {
        this.requestId = requestId;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Integer getUserFromId() {
        return userFromId;
    }

    public void setUserFromId(Integer userFromId) {
        this.userFromId = userFromId;
    }

    public Integer getUserToId() {
        return userToId;
    }

    public void setUserToId(Integer userToId) {
        this.userToId = userToId;
    }

    public Integer getBureoFromId() {
        return bureoFromId;
    }

    public void setBureoFromId(Integer bureoFromId) {
        this.bureoFromId = bureoFromId;
    }

    public Integer getBureoToId() {
        return bureoToId;
    }

    public void setBureoToId(Integer bureoToId) {
        this.bureoToId = bureoToId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        hash += (requestId != null ? requestId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requests)) {
            return false;
        }
        Requests other = (Requests) object;
        if ((this.requestId == null && other.requestId != null) || (this.requestId != null && !this.requestId.equals(other.requestId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Requests[ requestId=" + requestId + " ]";
    }

}
