package controller.admin;

import ejb.AdminBeanLocal;
import ejb.UserBeanLocal;
import java.util.Collection;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import viewentity.GetAllBureo;

@Named(value = "bureoController")
@RequestScoped
public class BureoController {

    @Inject
    AdminBeanLocal abl;

    @Inject
    UserBeanLocal ubl;

    public BureoController() {
    }

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
    private Date creationDate;
    private Date modificationDate;

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private Collection<GetAllBureo> getAllBureos;
    private GetAllBureo getAllbureo;

    public Collection<GetAllBureo> getGetAllBureos() {
        return abl.getAllBureo();
    }

    public void setGetAllBureos(Collection<GetAllBureo> getAllBureos) {
        this.getAllBureos = getAllBureos;
    }

    public GetAllBureo getGetAllbureo() {
        return getAllbureo;
    }

    public void setGetAllbureo(GetAllBureo gab) {
        userId = gab.getUserId();
        firstName = gab.getFirstName();
        lastName = gab.getLastName();
        email = gab.getEmail();
        phone = gab.getPhone();
        bureoId = gab.getBureoId();
        bureoName = gab.getBureoName();
        contactEmail = gab.getEmail();
        regNo = gab.getRegNo();
        isDeleted = gab.getIsDeleted();
        creationDate = gab.getCreationDate();
        modificationDate = gab.getModificationDate();
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

    public String addBureo() {
        abl.addBureoByAdmin(bureoName, regNo, firstName, lastName, email, phone);
        return "/auth/admin/bureos/index.xhtml?faces-redirect=true";
    }

    public String registerBureo() {
        ubl.registerBureo(bureoName, regNo, firstName, lastName, email, phone, password);
        return "/shared/login/login.xhtml?faces-redirect=true";
    }

    public String editBureo(Integer bid, Integer uid) {
        setGetAllbureo(abl.getBureoByAdminById(bid, uid));
        return "/auth/admin/bureos/edit.xhtml";
    }

    public String editBureo() {
        abl.updateBureoByAdmin(bureoId, userId, bureoName, regNo, firstName, lastName, email, phone);
        return "/auth/admin/bureos/index.xhtml?faces-redirect=true";
    }

    public String deleteBureo(Integer bid, Integer uid) {
        abl.deleteBureoByAdmin(bid, uid);
        return "/auth/admin/bureos/index.xhtml?faces-redirect=true";
    }
}
