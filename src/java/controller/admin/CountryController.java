package controller.admin;

import ejb.AdminBeanLocal;
import entity.Countries;
import java.util.Collection;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named(value = "countryController")
@RequestScoped
public class CountryController {

    @Inject
    AdminBeanLocal abl;

    public CountryController() {
    }

    private Integer countryId;
    private String countryName;
    private String countryCode;
    private Boolean isDeleted;
    private Date creationDate;
    private Date modificationDate;

    private Collection<Countries> countries;
    private Countries country;

    public Collection<Countries> getCountries() {
        return abl.getAllCountries();
    }

    public void setCountries(Collection<Countries> countries) {
        this.countries = countries;
    }

    public Countries getCountry() {
        return country;
    }

    public void setCountry(Countries country) {
        countryId = country.getCountryId();
        countryName = country.getCountryName();
        countryCode = country.getCountryCode();
        isDeleted = country.getIsDeleted();
        creationDate = country.getCreationDate();
        modificationDate = country.getModificationDate();
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

    public String addCountry() {
        abl.addCountry(countryName, countryCode);
        return "/auth/admin/countries/index.xhtml?faces-redirect=true";
    }

    public String editCountry(Integer Id) {
        setCountry(abl.getCountryById(Id));
        return "/auth/admin/countries/edit.xhtml";
    }

    public String editCountry() {
        abl.updateCountry(countryId, countryName, countryCode);
        return "/auth/admin/countries/index.xhtml?faces-redirect=true";
    }

    public String deleteCountry(Integer Id) {
        abl.deleteCountry(Id);
        return "/auth/admin/countries/index.xhtml?faces-redirect=true";
    }
}
