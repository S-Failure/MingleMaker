package ejb;

import javax.ejb.Local;

@Local
public interface UserBeanLocal {

    public void registerBureo(String bureoName, String regNo, String firstName, String lastName,
            String email, String phone, String password);

    public void sendRequest(Integer userId, Integer bureoId, Integer userIdTo, Integer bureoIdTo);
}
