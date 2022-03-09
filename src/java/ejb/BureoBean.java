package ejb;

import entity.Userdetails;
import entity.Userinroles;
import entity.Users;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import viewentity.GetAllUsers;

@Stateless
public class BureoBean implements BureoBeanLocal {

    @PersistenceContext
    EntityManager em;

    @Inject
    CommonBeanLocal cbl;

    @Override
    public Collection<GetAllUsers> getAllUsers() {
        String query = "SELECT u.UserId, u.FirstName, u.LastName, u.Email, u.Password, u.Phone, u.Photo, u.Gender, u.Age,"
                + " u.City, u.State, u.ZipCode, u.CountryId, u.IsDeleted, u.Creationdate, u.Modificationdate, "
                + "ud.UserDetailId, ud.BureoId, ud.EyeColour, ud.HairColour, ud.Height, ud.Education, ud.Education, "
                + "ud.MeritalStatus, ud.MotherTongue, ud.RequiredChild, ud.LookingFor, ud.Address,ud.Salary, "
                + "ud.Occupation,ud.WorkAddress FROM users u JOIN roles r ON r.RoleId = 3 JOIN userinroles uir ON "
                + "uir.UserId = u.UserId AND uir.RoleId = r.RoleId JOIN userdetails ud ON ud.UserId = u.UserId JOIN "
                + "marriagebureos mb ON mb.BureoId = ud.BureoId WHERE u.IsDeleted = 0 ORDER BY u.Creationdate DESC";

        return em.createNativeQuery(query, GetAllUsers.class)
                .getResultList();
    }

    @Override
    public Collection<GetAllUsers> getAllUsersByBureoId(Integer bureoId) {
        String query = "SELECT u.UserId, u.FirstName, u.LastName, u.Email, u.Password, u.Phone, u.Photo, u.Gender, u.Age, "
                + "u.City, u.State, u.ZipCode, u.CountryId, u.IsDeleted, u.Creationdate, u.Modificationdate, "
                + "ud.UserDetailId, ud.BureoId, ud.EyeColour, ud.HairColour, ud.Height, ud.Education, ud.Education, "
                + "ud.MeritalStatus, ud.MotherTongue, ud.RequiredChild, ud.LookingFor, ud.Address,ud.Salary, ud.Occupation,"
                + " ud.WorkAddress FROM users u JOIN roles r ON r.RoleId = 3 JOIN userinroles uir ON uir.UserId = u.UserId "
                + "AND uir.RoleId = r.RoleId JOIN userdetails ud ON ud.UserId = u.UserId JOIN marriagebureos mb ON "
                + "mb.BureoId = ud.BureoId WHERE u.IsDeleted = 0 AND mb.BureoId = ? ORDER BY u.Creationdate DESC";

        return em.createNativeQuery(query, GetAllUsers.class)
                .setParameter(1, bureoId)
                .getResultList();
    }

    @Override
    public void addUserByBureo(Integer bureoId, String firstName, String lastName, String email, String password, String phone, String photo, String gender, Integer age, String city, String state, String zipcode, Integer countryId, String eyeColour, String hairColour, String height, String education, String maritalStatus, String motherTongue, String lookingFor, String address, String salary, String occuption, String workAddress) {
        Users user = new Users();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(cbl.getAppSetting("DefaultPassword"));
        user.setPhone(phone);
        user.setPhoto(photo);
        user.setGender(gender);
        user.setAge(age);
        user.setCity(city);
        user.setState(state);
        user.setZipCode(zipcode);
        user.setCountryId(countryId);
        user.setIsDeleted(false);
        user.setCreationdate(new Date());
        user.setModificationdate(null);
        em.persist(user);
        em.flush();

        Userdetails ud = new Userdetails();
        ud.setUserId(user.getUserId());
        ud.setBureoId(bureoId);
        ud.setEyeColour(eyeColour);
        ud.setHairColour(hairColour);
        ud.setHeight(height);
        ud.setEducation(education);
        ud.setMeritalStatus(maritalStatus);
        ud.setMotherTongue(motherTongue);
        ud.setRequiredChild(true);
        ud.setLookingFor(lookingFor);
        ud.setAddress(address);
        ud.setSalary(salary);
        ud.setOccupation(occuption);
        ud.setWorkAddress(workAddress);
        ud.setCreationdate(new Date());
        ud.setModificationdate(null);
        em.persist(ud);

        Userinroles uir = new Userinroles();
        uir.setUserId(user.getUserId());
        uir.setRoleId(3);
        em.persist(uir);
    }

    @Override
    public void updateUserByBureo(Integer userId, Integer userDetailId, Integer bureoId, String firstName, String lastName, String email, String password, String phone, String photo, String gender, Integer age, String city, String state, String zipcode, Integer countryId, String eyeColour, String hairColour, String height, String education, String maritalStatus, String motherTongue, String lookingFor, String address, String salary, String occuption, String workAddress) {
        Users user = em.find(Users.class, userId);
        user.setUserId(userId);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        user.setPhoto(photo);
        user.setGender(gender);
        user.setAge(age);
        user.setCity(city);
        user.setState(state);
        user.setZipCode(zipcode);
        user.setCountryId(countryId);
        user.setIsDeleted(false);
        user.setModificationdate(new Date());
        em.merge(user);

        Userdetails ud = em.find(Userdetails.class, userDetailId);
        ud.setUserDetailId(userDetailId);
        ud.setUserId(user.getUserId());
        ud.setBureoId(bureoId);
        ud.setEyeColour(eyeColour);
        ud.setHairColour(hairColour);
        ud.setHeight(height);
        ud.setEducation(education);
        ud.setMeritalStatus(maritalStatus);
        ud.setMotherTongue(motherTongue);
        ud.setRequiredChild(true);
        ud.setLookingFor(lookingFor);
        ud.setAddress(address);
        ud.setSalary(salary);
        ud.setOccupation(occuption);
        ud.setWorkAddress(workAddress);
        ud.setModificationdate(new Date());
        em.merge(ud);
    }

    @Override
    public GetAllUsers getUserByUserById(Integer userId, Integer userDetailId, Integer bureoId) {
        String query = "SELECT u.UserId, u.FirstName, u.LastName, u.Email, u.Password, u.Phone, u.Photo, u.Gender, "
                + "u.Age, u.City, u.State, u.ZipCode, u.CountryId, u.IsDeleted, u.Creationdate, "
                + "u.Modificationdate, ud.UserDetailId, ud.BureoId, ud.EyeColour, ud.HairColour, ud.Height, "
                + "ud.Education, ud.Education, ud.MeritalStatus, ud.MotherTongue, ud.RequiredChild, ud.LookingFor, "
                + "ud.Address,ud.Salary, ud.Occupation, ud.WorkAddress FROM users u JOIN roles r ON r.RoleId = 3 JOIN "
                + "userinroles uir ON uir.UserId = u.UserId AND uir.RoleId = r.RoleId JOIN userdetails ud ON "
                + "ud.UserId = u.UserId JOIN marriagebureos mb ON mb.BureoId = ud.BureoId WHERE u.IsDeleted = 0 AND "
                + "mb.BureoId = ? AND u.UserId = ?  AND ud.UserDetailId = ? ORDER BY u.Creationdate DESC";

        return (GetAllUsers) em.createNativeQuery(query, GetAllUsers.class)
                .setParameter(1, bureoId)
                .setParameter(2, userId)
                .setParameter(3, userDetailId)
                .getSingleResult();
    }

    @Override
    public void deleteUser(Integer userId, Integer userDetailId, Integer bureoId) {
        Users user = em.find(Users.class, userId);
        user.setUserId(userId);
        user.setIsDeleted(true);
        user.setModificationdate(new Date());
        em.merge(user);

        Userdetails ud = em.find(Userdetails.class, userDetailId);
        ud.setUserDetailId(userDetailId);
        ud.setUserId(user.getUserId());
        ud.setBureoId(bureoId);
        ud.setModificationdate(new Date());
        em.merge(ud);
    }

}
