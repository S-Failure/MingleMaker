package viewentity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class GetAllBureo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Integer bureoId;
    private String bureoName;
    private String contactEmail;
    private String regNo;
    private Boolean isDeleted;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date creationDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date modificationDate;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getBureoId() {
        return bureoId;
    }

    public void setBureoId(Integer bureoId) {
        this.bureoId = bureoId;
    }

    public String getBureoName() {
        return bureoName;
    }

    public void setBureoName(String bureoName) {
        this.bureoName = bureoName;
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

    @Override
    public String toString() {
        return "GetAllBureo{" + "userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone + ", bureoId=" + bureoId + ", bureoName=" + bureoName + ", contactEmail=" + contactEmail + ", regNo=" + regNo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.userId);
        hash = 43 * hash + Objects.hashCode(this.firstName);
        hash = 43 * hash + Objects.hashCode(this.lastName);
        hash = 43 * hash + Objects.hashCode(this.email);
        hash = 43 * hash + Objects.hashCode(this.phone);
        hash = 43 * hash + Objects.hashCode(this.bureoId);
        hash = 43 * hash + Objects.hashCode(this.bureoName);
        hash = 43 * hash + Objects.hashCode(this.contactEmail);
        hash = 43 * hash + Objects.hashCode(this.regNo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GetAllBureo other = (GetAllBureo) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.bureoName, other.bureoName)) {
            return false;
        }
        if (!Objects.equals(this.contactEmail, other.contactEmail)) {
            return false;
        }
        if (!Objects.equals(this.regNo, other.regNo)) {
            return false;
        }
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        if (!Objects.equals(this.bureoId, other.bureoId)) {
            return false;
        }
        return true;
    }

}
