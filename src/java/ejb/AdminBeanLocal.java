package ejb;

import entity.Countries;
import entity.Roles;
import entity.Users;
import java.util.Collection;
import javax.ejb.Local;
import viewentity.GetAllBureo;

@Local
public interface AdminBeanLocal {

    //Role
    public Collection<Roles> getAllRoles();

    public void addRole(String roleName);

    public void updateRole(Integer roleId, String roleName);

    public Roles getRoleById(Integer roleId);

    public void deleteRole(Integer roleId);

    //Users
    Collection<Users> getAllUsers();

    public Users getUserById(Integer userId);

    public void addUser(String email, String password);

    public void updateUser(Integer userId, String email, String password);

    public void deleteUser(Integer userId);

    //Countries
    Collection<Countries> getAllCountries();

    public Countries getCountryById(Integer countryId);

    public void addCountry(String countryName, String countryCode);

    public void updateCountry(Integer countryId, String countryName, String countryCode);

    public void deleteCountry(Integer countryId);

    //Bureo by admin
    public void addBureoByAdmin(String bureoName, String regNo, String firstName, String lastName,
            String email, String phone);

    public Collection<GetAllBureo> getAllBureo();

    public void updateBureoByAdmin(Integer bureoId, Integer userId, String bureoName, String regNo, String firstName,
            String lastName, String email, String phone);

    public void deleteBureoByAdmin(Integer bureoId, Integer userId);

    public GetAllBureo getBureoByAdminById(Integer bureoId, Integer userId);

    //own
    public void updateAdminDetailById(Integer userId, String firstName, String lastName, String email, String password,
            String phone, String photo, String gender, String age, String city, String state, String zipcode, Integer countryId);
}
