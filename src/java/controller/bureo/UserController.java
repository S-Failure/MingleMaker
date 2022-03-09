package controller.bureo;

import ejb.AdminBeanLocal;
import ejb.BureoBeanLocal;
import ejb.UserBeanLocal;
import entity.Countries;
import java.util.Collection;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import viewentity.GetAllUsers;

@Named(value = "userController")
@RequestScoped
public class UserController {

    @Inject
    BureoBeanLocal bbl;

    @Inject
    AdminBeanLocal abl;

    @Inject
    UserBeanLocal ubl;

    public UserController() {
    }

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
    private Date creationdate;
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

    private Collection<GetAllUsers> allusers;
    private GetAllUsers getalluser;

    private Collection<Countries> countries;

    private Integer totalUser;

    private Collection<GetAllUsers> users;

    public Collection<GetAllUsers> getUsers() {
        return bbl.getAllUsers();
    }

    public void setUsers(Collection<GetAllUsers> users) {
        this.users = users;
    }

    public Integer getTotalUser() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

        if (session == null) {
            return 0;
        }

        Integer Id = Integer.parseInt(session.getAttribute("bureoId").toString());
        return bbl.getAllUsersByBureoId(Id).size();
    }

    public void setTotalUser(Integer totalUser) {
        this.totalUser = totalUser;
    }

    public Collection<Countries> getCountries() {
        return abl.getAllCountries();
    }

    public void setCountries(Collection<Countries> countries) {
        this.countries = countries;
    }

    public Collection<GetAllUsers> getAllusers() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

        if (session == null) {
            return null;
        }

        Integer id = Integer.parseInt(session.getAttribute("bureoId").toString());
        return bbl.getAllUsersByBureoId(id);
    }

    public void setAllusers(Collection<GetAllUsers> allusers) {
        this.allusers = allusers;
    }

    public GetAllUsers getGetalluser() {
        return getalluser;
    }

    public void setGetalluser(GetAllUsers g) {
        userId = g.getUserId();
        firstName = g.getFirstName();
        lastName = g.getLastName();
        email = g.getEmail();
        password = g.getPassword();
        phone = g.getPhone();
        photo = g.getPhoto();
        gender = g.getGender();
        age = g.getAge();
        city = g.getCity();
        state = g.getState();
        zipCode = g.getZipCode();
        countryId = g.getCountryId();
        isDeleted = g.getIsDeleted();
        creationdate = g.getCreationdate();
        modificationdate = g.getModificationdate();
        userDetailId = g.getUserDetailId();
        bureoId = g.getBureoId();
        eyeColour = g.getEyeColour();
        hairColour = g.getHairColour();
        height = g.getHeight();
        education = g.getEducation();
        meritalStatus = g.getMeritalStatus();
        motherTongue = g.getMotherTongue();
        requiredChild = g.getRequiredChild();
        lookingFor = g.getLookingFor();
        address = g.getAddress();
        salary = g.getSalary();
        occupation = g.getOccupation();
        workAddress = g.getWorkAddress();
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

    public String addUser() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

        if (session == null) {
            return "/shared/login/login.xhtml?faces-redirect=true";
        }

        bureoId = Integer.parseInt(session.getAttribute("bureoId").toString());

        bbl.addUserByBureo(bureoId, firstName, lastName, email, password, phone, photo, gender, age, city, state, zipCode, countryId, eyeColour, hairColour, height, education, meritalStatus, motherTongue, lookingFor, address, salary, occupation, workAddress);

        return "/auth/bureo/users/index.xhtml?faces-redirect=true";
    }

    public String getUserForUpdate(Integer Id, Integer uid, Integer bid) {
        setGetalluser(bbl.getUserByUserById(Id, uid, bid));
        return "/auth/bureo/users/edit.xhtml";
    }

    public String updateUser() {
        bbl.updateUserByBureo(userId, userDetailId, bureoId, firstName, lastName, email, password, phone, photo, gender, age, city, state, zipCode, countryId, eyeColour, hairColour, height, education, meritalStatus, motherTongue, lookingFor, address, salary, occupation, workAddress);
        return "/auth/bureo/users/index.xhtml?faces-redirect=true";
    }

    public String deleteUser(Integer Id, Integer uid, Integer bid) {
        bbl.deleteUser(Id, uid, bid);
        return "/auth/bureo/users/index.xhtml?faces-redirect=true";
    }

    public String sendRequest(Integer IdTo, Integer bidTo) {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Integer id = Integer.parseInt(session.getAttribute("userId").toString());
        Integer bid = Integer.parseInt(session.getAttribute("bureoId").toString());

        ubl.sendRequest(id, IdTo, bid, bidTo);
        return "/auth/user/users/index.xhtml?faces-redirect=true";
    }
}
