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
@Table(name = "documents")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documents.findAll", query = "SELECT d FROM Documents d"),
    @NamedQuery(name = "Documents.findByDocumentId", query = "SELECT d FROM Documents d WHERE d.documentId = :documentId"),
    @NamedQuery(name = "Documents.findByUserId", query = "SELECT d FROM Documents d WHERE d.userId = :userId"),
    @NamedQuery(name = "Documents.findByBureoId", query = "SELECT d FROM Documents d WHERE d.bureoId = :bureoId"),
    @NamedQuery(name = "Documents.findByDocument", query = "SELECT d FROM Documents d WHERE d.document = :document"),
    @NamedQuery(name = "Documents.findByIsDeleted", query = "SELECT d FROM Documents d WHERE d.isDeleted = :isDeleted"),
    @NamedQuery(name = "Documents.findByCreationDate", query = "SELECT d FROM Documents d WHERE d.creationDate = :creationDate"),
    @NamedQuery(name = "Documents.findByModificationDate", query = "SELECT d FROM Documents d WHERE d.modificationDate = :modificationDate")})
public class Documents implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DocumentId")
    private Integer documentId;
    @Column(name = "UserId")
    private Integer userId;
    @Column(name = "BureoId")
    private Integer bureoId;
    @Size(max = 1000)
    @Column(name = "Document")
    private String document;
    @Column(name = "IsDeleted")
    private Boolean isDeleted;
    @Column(name = "CreationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "ModificationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;

    public Documents() {
    }

    public Documents(Integer documentId) {
        this.documentId = documentId;
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
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

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
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
        hash += (documentId != null ? documentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documents)) {
            return false;
        }
        Documents other = (Documents) object;
        if ((this.documentId == null && other.documentId != null) || (this.documentId != null && !this.documentId.equals(other.documentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Documents[ documentId=" + documentId + " ]";
    }

}
