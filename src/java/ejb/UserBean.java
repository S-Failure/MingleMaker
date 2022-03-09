package ejb;

import entity.Marriagebureos;
import entity.Requests;
import entity.Userinroles;
import entity.Users;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserBean implements UserBeanLocal {

    @PersistenceContext
    EntityManager em;

    @Override
    public void registerBureo(String bureoName, String regNo, String firstName, String lastName, String email, String phone, String password) {
        Users user = new Users();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
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
    public void sendRequest(Integer userId, Integer bureoId, Integer userIdTo, Integer bureoIdTo) {
        Requests r = new Requests();
        r.setUserFromId(userId);
        r.setUserToId(userIdTo);
        r.setBureoFromId(bureoId);
        r.setBureoToId(bureoIdTo);
        r.setStatus(1);
        r.setIsDeleted(false);
        r.setCreationDate(new Date());
        r.setModificationDate(null);
        em.persist(r);
    }
}
