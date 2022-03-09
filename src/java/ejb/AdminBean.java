package ejb;

import entity.Countries;
import entity.Marriagebureos;
import entity.Roles;
import entity.Userinroles;
import entity.Users;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import viewentity.GetAllBureo;

@Stateless
public class AdminBean implements AdminBeanLocal {

    @PersistenceContext(unitName = "persistence")
    EntityManager em;

    @Inject
    CommonBeanLocal cbl;

    @Override
    public Collection<Roles> getAllRoles() {
        String query = "SELECT * FROM roles WHERE IsDeleted = 0 ORDER BY CreationDate DESC";
        return em.createNativeQuery(query, Roles.class).getResultList();
    }

    @Override
    public void addRole(String roleName) {
        Roles role = new Roles();
        role.setRoleName(roleName);
        role.setIsDeleted(false);
        role.setCreationDate(new Date());
        role.setModificationDate(null);
        em.persist(role);
    }

    @Override
    public void updateRole(Integer roleId, String roleName) {
        Roles role = em.find(Roles.class, roleId);
        role.setRoleId(roleId);
        role.setRoleName(roleName);
        role.setIsDeleted(false);
        role.setModificationDate(new Date());
        em.merge(role);
    }

    @Override
    public Roles getRoleById(Integer roleId) {
        String query = "SELECT * FROM roles WHERE IsDeleted = 0 AND RoleId = ?";
        return (Roles) em.createNativeQuery(query, Roles.class).setParameter(1, roleId).getSingleResult();
    }

    @Override
    public void deleteRole(Integer roleId) {
        Roles role = em.find(Roles.class, roleId);
        role.setRoleId(roleId);
        role.setIsDeleted(true);
        role.setModificationDate(new Date());
        em.merge(role);
    }

    @Override
    public Collection<Users> getAllUsers() {
        String query = "SELECT * FROM users WHERE IsDeleted = 0 ORDER BY CreationDate DESC";
        return em.createNativeQuery(query, Users.class).getResultList();
    }

    @Override
    public Users getUserById(Integer userId) {
        String query = "SELECT * FROM users WHERE IsDeleted = 0 AND UserId = ? ORDER BY CreationDate DESC";
        return (Users) em.createNativeQuery(query, Users.class).setParameter(1, userId).getSingleResult();
    }

    @Override
    public void addUser(String email, String password) {
        Users user = new Users();
        user.setEmail(email);
        user.setPassword(password);
        user.setCreationdate(new Date());
        em.persist(user);
    }

    @Override
    public void updateUser(Integer userId, String email, String password) {
        Users user = em.find(Users.class, userId);
        user.setUserId(userId);
        user.setEmail(email);
        user.setPassword(password);
        user.setModificationdate(new Date());
        em.merge(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        Users user = em.find(Users.class, userId);
        user.setUserId(userId);
        user.setIsDeleted(true);
        user.setModificationdate(new Date());
        em.merge(user);
    }

    @Override
    public Collection<Countries> getAllCountries() {
        String query = "SELECT * FROM countries WHERE IsDeleted = 0 ORDER BY CreationDate DESC";
        return em.createNativeQuery(query, Countries.class).getResultList();
    }

    @Override
    public Countries getCountryById(Integer countryId) {
        String query = "SELECT * FROM countries WHERE IsDeleted = 0 AND CountryId = ? ORDER BY CreationDate DESC";
        return (Countries) em.createNativeQuery(query, Countries.class).setParameter(1, countryId).getSingleResult();
    }

    @Override
    public void addCountry(String countryName, String countryCode) {
        Countries country = new Countries();
        country.setCountryName(countryName);
        country.setCountryCode(countryCode);
        country.setCreationDate(new Date());
        country.setIsDeleted(false);
        country.setModificationDate(null);
        em.persist(country);
    }

    @Override
    public void updateCountry(Integer countryId, String countryName, String countryCode) {
        Countries country = em.find(Countries.class, countryId);
        country.setCountryId(countryId);
        country.setCountryName(countryName);
        country.setCountryCode(countryCode);
        country.setIsDeleted(false);
        country.setModificationDate(new Date());
        em.merge(country);
    }

    @Override
    public void deleteCountry(Integer countryId) {
        Countries country = em.find(Countries.class, countryId);
        country.setCountryId(countryId);
        country.setIsDeleted(true);
        country.setModificationDate(new Date());
        em.merge(country);
    }

    @Override
    public void addBureoByAdmin(String bureoName, String regNo, String firstName, String lastName, String email, String phone) {
        Users user = new Users();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(cbl.getAppSetting("DefaultPassword"));
        user.setPhone(phone);
        user.setPhoto(null);
        user.setGender(null);
        user.setAge(null);
        user.setCity(null);
        user.setState(null);
        user.setZipCode(null);
        user.setCountryId(null);
        user.setIsDeleted(false);
        user.setCreationdate(new Date());
        user.setModificationdate(null);
        em.persist(user);
        em.flush();

        Marriagebureos mb = new Marriagebureos();
        mb.setUserId(user.getUserId());
        mb.setBureoName(bureoName);
        mb.setBureoAddress(null);
        mb.setContactEmail(email);
        mb.setRegNo(regNo);
        mb.setDescription(null);
        mb.setIsDeleted(false);
        mb.setCreationDate(new Date());
        mb.setModificationDate(null);
        em.persist(mb);
        Userinroles uir = new Userinroles();
        uir.setUserId(user.getUserId());
        uir.setRoleId(2);
        uir.setCreationDate(new Date());
        em.persist(uir);
    }

    @Override
    public Collection<GetAllBureo> getAllBureo() {
        String query = "SELECT u.FirstName, u.LastName, u.Phone, u.UserId, mb.BureoId, mb.BureoName, mb.RegNo, mb.ContactEmail AS Email, "
                + "u.IsDeleted, u.Creationdate, u.Modificationdate FROM users u JOIN marriagebureos mb ON mb.UserId = u.UserId JOIN "
                + "userinroles ur ON ur.UserId = u.UserId AND ur.RoleId = 2 WHERE u.IsDeleted = 0 AND mb.IsDeleted = 0 ORDER BY mb.CreationDate DESC";
        return em.createNativeQuery(query, GetAllBureo.class).getResultList();
    }

    @Override
    public void updateBureoByAdmin(Integer bureoId, Integer userId, String bureoName, String regNo, String firstName, String lastName, String email, String phone) {
        Users user = em.find(Users.class, userId);
        user.setUserId(userId);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPhone(phone);
        user.setPhoto(null);
        user.setGender(null);
        user.setAge(null);
        user.setCity(null);
        user.setState(null);
        user.setZipCode(null);
        user.setCountryId(null);
        user.setIsDeleted(false);
        user.setModificationdate(new Date());
        em.merge(user);

        Marriagebureos mb = em.find(Marriagebureos.class, bureoId);
        mb.setBureoId(bureoId);
        mb.setUserId(userId);
        mb.setBureoName(bureoName);
        mb.setBureoAddress(null);
        mb.setContactEmail(email);
        mb.setRegNo(regNo);
        mb.setDescription(null);
        mb.setIsDeleted(false);
        mb.setModificationDate(new Date());
        em.merge(mb);
    }

    @Override
    public void deleteBureoByAdmin(Integer bureoId, Integer userId) {
        Users user = em.find(Users.class, userId);
        user.setUserId(userId);
        user.setIsDeleted(true);
        user.setModificationdate(new Date());
        em.merge(user);

        Marriagebureos mb = em.find(Marriagebureos.class, bureoId);
        mb.setBureoId(bureoId);
        mb.setUserId(userId);
        mb.setIsDeleted(true);
        mb.setModificationDate(new Date());
        em.merge(mb);
    }

    @Override
    public GetAllBureo getBureoByAdminById(Integer bureoId, Integer userId) {
        String query = "SELECT u.FirstName, u.LastName, u.Phone, u.UserId, mb.BureoId, mb.BureoName, mb.RegNo, mb.ContactEmail AS Email, u.IsDeleted, "
                + "u.Creationdate, u.Modificationdate FROM users u JOIN marriagebureos mb ON mb.UserId = u.UserId JOIN userinroles ur "
                + "ON ur.UserId = u.UserId AND ur.RoleId = 2 WHERE u.IsDeleted = 0 AND mb.IsDeleted = 0 AND mb.BureoId = ? AND mb.UserId = ? ORDER BY mb.CreationDate DESC";
        return (GetAllBureo) em.createNativeQuery(query, GetAllBureo.class)
                .setParameter(1, bureoId)
                .setParameter(2, userId)
                .getSingleResult();
    }

    @Override
    public void updateAdminDetailById(Integer userId, String firstName, String lastName, String email, String password, String phone, String photo, String gender, String age, String city, String state, String zipcode, Integer countryId) {
        Users user = em.find(Users.class, userId);
        user.setUserId(userId);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPhoto(photo);
        user.setGender(gender);
        user.setAge(userId);
        user.setCity(city);
        user.setState(state);
        user.setZipCode(zipcode);
        user.setCountryId(countryId);
        user.setIsDeleted(false);
        user.setModificationdate(new Date());
        em.merge(user);
    }

}
