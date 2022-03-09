package viewentity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class GetAllUsers implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String photo;
    private String gender;
    private Integer age;
    private String city;
    private String state;
    private String zipCode;
    private Integer countryId;
    private Boolean isDeleted;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date creationdate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date modificationdate;

    private Integer userDetailId;
    private Integer bureoId;
    private String eyeColour;
    private String hairColour;
    private String height;
    private String education;
    private String meritalStatus;
    private String motherTongue;
    private Boolean requiredChild;
    private String lookingFor;
    private String address;
    private String salary;
    private String occupation;
    private String workAddress;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
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

    public Integer getUserDetailId() {
        return userDetailId;
    }

    public void setUserDetailId(Integer userDetailId) {
        this.userDetailId = userDetailId;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.userId);
        hash = 53 * hash + Objects.hashCode(this.firstName);
        hash = 53 * hash + Objects.hashCode(this.lastName);
        hash = 53 * hash + Objects.hashCode(this.email);
        hash = 53 * hash + Objects.hashCode(this.password);
        hash = 53 * hash + Objects.hashCode(this.phone);
        hash = 53 * hash + Objects.hashCode(this.photo);
        hash = 53 * hash + Objects.hashCode(this.gender);
        hash = 53 * hash + Objects.hashCode(this.age);
        hash = 53 * hash + Objects.hashCode(this.city);
        hash = 53 * hash + Objects.hashCode(this.state);
        hash = 53 * hash + Objects.hashCode(this.zipCode);
        hash = 53 * hash + Objects.hashCode(this.countryId);
        hash = 53 * hash + Objects.hashCode(this.isDeleted);
        hash = 53 * hash + Objects.hashCode(this.creationdate);
        hash = 53 * hash + Objects.hashCode(this.modificationdate);
        hash = 53 * hash + Objects.hashCode(this.userDetailId);
        hash = 53 * hash + Objects.hashCode(this.bureoId);
        hash = 53 * hash + Objects.hashCode(this.eyeColour);
        hash = 53 * hash + Objects.hashCode(this.hairColour);
        hash = 53 * hash + Objects.hashCode(this.height);
        hash = 53 * hash + Objects.hashCode(this.education);
        hash = 53 * hash + Objects.hashCode(this.meritalStatus);
        hash = 53 * hash + Objects.hashCode(this.motherTongue);
        hash = 53 * hash + Objects.hashCode(this.requiredChild);
        hash = 53 * hash + Objects.hashCode(this.lookingFor);
        hash = 53 * hash + Objects.hashCode(this.address);
        hash = 53 * hash + Objects.hashCode(this.salary);
        hash = 53 * hash + Objects.hashCode(this.occupation);
        hash = 53 * hash + Objects.hashCode(this.workAddress);
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
        final GetAllUsers other = (GetAllUsers) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.photo, other.photo)) {
            return false;
        }
        if (!Objects.equals(this.gender, other.gender)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.zipCode, other.zipCode)) {
            return false;
        }
        if (!Objects.equals(this.eyeColour, other.eyeColour)) {
            return false;
        }
        if (!Objects.equals(this.hairColour, other.hairColour)) {
            return false;
        }
        if (!Objects.equals(this.height, other.height)) {
            return false;
        }
        if (!Objects.equals(this.education, other.education)) {
            return false;
        }
        if (!Objects.equals(this.meritalStatus, other.meritalStatus)) {
            return false;
        }
        if (!Objects.equals(this.motherTongue, other.motherTongue)) {
            return false;
        }
        if (!Objects.equals(this.lookingFor, other.lookingFor)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.salary, other.salary)) {
            return false;
        }
        if (!Objects.equals(this.occupation, other.occupation)) {
            return false;
        }
        if (!Objects.equals(this.workAddress, other.workAddress)) {
            return false;
        }
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        if (!Objects.equals(this.age, other.age)) {
            return false;
        }
        if (!Objects.equals(this.countryId, other.countryId)) {
            return false;
        }
        if (!Objects.equals(this.isDeleted, other.isDeleted)) {
            return false;
        }
        if (!Objects.equals(this.creationdate, other.creationdate)) {
            return false;
        }
        if (!Objects.equals(this.modificationdate, other.modificationdate)) {
            return false;
        }
        if (!Objects.equals(this.userDetailId, other.userDetailId)) {
            return false;
        }
        if (!Objects.equals(this.bureoId, other.bureoId)) {
            return false;
        }
        if (!Objects.equals(this.requiredChild, other.requiredChild)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GetAllUsers{" + "userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password + ", phone=" + phone + ", photo=" + photo + ", gender=" + gender + ", age=" + age + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + ", countryId=" + countryId + ", isDeleted=" + isDeleted + ", creationdate=" + creationdate + ", modificationdate=" + modificationdate + ", userDetailId=" + userDetailId + ", bureoId=" + bureoId + ", eyeColour=" + eyeColour + ", hairColour=" + hairColour + ", height=" + height + ", education=" + education + ", meritalStatus=" + meritalStatus + ", motherTongue=" + motherTongue + ", requiredChild=" + requiredChild + ", lookingFor=" + lookingFor + ", address=" + address + ", salary=" + salary + ", occupation=" + occupation + ", workAddress=" + workAddress + '}';
    }

}
