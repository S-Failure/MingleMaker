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
@Table(name = "userinroles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userinroles.findAll", query = "SELECT u FROM Userinroles u"),
    @NamedQuery(name = "Userinroles.findByUserInRoleId", query = "SELECT u FROM Userinroles u WHERE u.userInRoleId = :userInRoleId"),
    @NamedQuery(name = "Userinroles.findByUserId", query = "SELECT u FROM Userinroles u WHERE u.userId = :userId"),
    @NamedQuery(name = "Userinroles.findByRoleId", query = "SELECT u FROM Userinroles u WHERE u.roleId = :roleId"),
    @NamedQuery(name = "Userinroles.findByCreationDate", query = "SELECT u FROM Userinroles u WHERE u.creationDate = :creationDate")})
public class Userinroles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UserInRoleId")
    private Integer userInRoleId;
    @Column(name = "UserId")
    private Integer userId;
    @Column(name = "RoleId")
    private Integer roleId;
    @Column(name = "CreationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    public Userinroles() {
    }

    public Userinroles(Integer userInRoleId) {
        this.userInRoleId = userInRoleId;
    }

    public Integer getUserInRoleId() {
        return userInRoleId;
    }

    public void setUserInRoleId(Integer userInRoleId) {
        this.userInRoleId = userInRoleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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
        hash += (userInRoleId != null ? userInRoleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userinroles)) {
            return false;
        }
        Userinroles other = (Userinroles) object;
        if ((this.userInRoleId == null && other.userInRoleId != null) || (this.userInRoleId != null && !this.userInRoleId.equals(other.userInRoleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Userinroles[ userInRoleId=" + userInRoleId + " ]";
    }

}
