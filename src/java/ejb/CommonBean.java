package ejb;

import entity.Appsettings;
import entity.Marriagebureos;
import entity.Roles;
import entity.Users;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class CommonBean implements CommonBeanLocal {

    @PersistenceContext
    EntityManager em;

    @Override
    public String getAppSetting(String key) {
        String query = "select * from appsettings where AppKey = ?";
        Appsettings appsetting = (Appsettings) em.createNativeQuery(query, Appsettings.class).setParameter(1, key).getSingleResult();
        return appsetting.getAppValue();
    }

    @Override
    public Users doLogin(String email, String password) {
        try {
            String query = "SELECT * FROM users WHERE IsDeleted = 0 AND Email = ? AND PASSWORD = ?";
            return (Users) em.createNativeQuery(query, Users.class)
                    .setParameter(1, email)
                    .setParameter(2, password)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public String getRoleNameByLogin(String email, String password) {
        String query = "SELECT r.RoleId, r.RoleName, r.IsDeleted, r.CreationDate, r.ModificationDate FROM users u JOIN userinroles uir "
                + "ON uir.UserId = u.UserId JOIN roles r ON r.RoleId = uir.RoleId AND r.IsDeleted = 0 WHERE u.IsDeleted = 0 AND r.IsDeleted = 0 "
                + "AND u.Email = ? AND u.Password = ?";
        Roles role = (Roles) em.createNativeQuery(query, Roles.class)
                .setParameter(1, email)
                .setParameter(2, password)
                .getSingleResult();
        return role.getRoleName();
    }

    @Override
    public Integer getBureoIdByLogin(String email, String password) {
        try {
            String query = "SELECT mb.BureoId, mb.UserId, mb.BureoName, mb.BureoAddress, mb.ContactEmail, mb.RegNo, mb.Description, "
                    + "mb.IsDeleted, mb.CreationDate, mb.ModificationDate FROM marriagebureos mb JOIN roles r ON r.RoleId = 2 AND "
                    + "r.IsDeleted = 0 JOIN users u ON u.IsDeleted = 0 AND u.Email = ? AND u.Password = ? JOIN userinroles uir ON "
                    + "uir.UserId = u.UserId AND uir.RoleId = r.RoleId WHERE mb.UserId = u.UserId AND mb.IsDeleted = 0";

            Marriagebureos mb = (Marriagebureos) em.createNativeQuery(query, Marriagebureos.class)
                    .setParameter(1, email)
                    .setParameter(2, password)
                    .getSingleResult();
            return mb.getBureoId();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Integer getBureoIdByLoginForUser(String email, String password) {
        try {
            String query = "SELECT mb.BureoId, mb.UserId, mb.BureoName, mb.BureoAddress, mb.ContactEmail, mb.RegNo, "
                    + "mb.Description, mb.IsDeleted, mb.CreationDate, mb.ModificationDate FROM marriagebureos mb JOIN "
                    + "users u ON u.Email = ? AND u.Password = ? AND u.IsDeleted = 0 JOIN userdetails ud ON ud.UserId ="
                    + " u.UserId AND ud.BureoId = mb.BureoId WHERE mb.IsDeleted = 0";

            Marriagebureos mb = (Marriagebureos) em.createNativeQuery(query, Marriagebureos.class)
                    .setParameter(1, email)
                    .setParameter(2, password)
                    .getSingleResult();
            return mb.getBureoId();
        } catch (NoResultException e) {
            return null;
        }
    }
}
