package controller.admin;

import ejb.AdminBeanLocal;
import entity.Countries;
import entity.Users;
import java.util.Collection;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@Named(value = "dashboardController")
@RequestScoped
public class DashboardController {

    @Inject
    AdminBeanLocal abl;

    public DashboardController() {
    }

    private Integer totalRole;
    private Integer totalBureo;
    private Integer totalCountry;

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

    private Users user;

    private Collection<Countries> countries;

    public Collection<Countries> getCountries() {
        return abl.getAllCountries();
    }

    public void setCountries(Collection<Countries> countries) {
        this.countries = countries;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        userId = user.getUserId();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        email = user.getEmail();
        password = user.getPassword();
        phone = user.getPhone();
        photo = user.getPhoto();
        gender = user.getGender();
        age = user.getAge();
        city = user.getCity();
        state = user.getState();
        zipCode = user.getZipCode();
        countryId = user.getCountryId();
        isDeleted = user.getIsDeleted();
        creationdate = user.getCreationdate();
        modificationdate = user.getModificationdate();
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

    public Integer getTotalRole() {
        return abl.getAllRoles().size();
    }

    public void setTotalRole(Integer totalRole) {
        this.totalRole = totalRole;
    }

    public Integer getTotalBureo() {
        return abl.getAllBureo().size();
    }

    public void setTotalBureo(Integer totalBureo) {
        this.totalBureo = totalBureo;
    }

    public Integer getTotalCountry() {
        return abl.getAllCountries().size();
    }

    public void setTotalCountry(Integer totalCountry) {
        this.totalCountry = totalCountry;
    }

    public String getAdminDetail() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

        if (session == null) {
            return "/shared/login/login.xhtml?faces-redirect=true";
        }

        Integer id = Integer.parseInt(session.getAttribute("userId").toString());
        String roleName = session.getAttribute("rolename").toString();
        setUser(abl.getUserById(id));
        if ("Super Admin".equals(roleName)) {
            return "/auth/admin/dashboard/editprofile.xhtml";
        } else if ("Bureo Admin".equals(roleName)) {
            return "/auth/bureo/dashboard/editprofile.xhtml";
        } else {
            return "/auth/user/dashboard/editprofile.xhtml";
        }
    }

    public String editAdminDetail() {
        abl.updateAdminDetailById(userId, firstName, lastName, email, password, phone, photo, gender, state, city, state, zipCode, countryId);

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        String roleName = session.getAttribute("rolename").toString();

        if ("Super Admin".equals(roleName)) {
            return "/auth/admin/dashboard/editprofile.xhtml";
        } else if ("Bureo Admin".equals(roleName)) {
            return "/auth/bureo/dashboard/editprofile.xhtml";
        } else {
            return "/auth/user/dashboard/editprofile.xhtml";
        }
    }
}
