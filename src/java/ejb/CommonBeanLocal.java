package ejb;

import entity.Users;
import javax.ejb.Local;

@Local
public interface CommonBeanLocal {

    public String getAppSetting(String key);

    public Users doLogin(String email, String password);

    public String getRoleNameByLogin(String email, String password);

    public Integer getBureoIdByLogin(String email, String password);

    public Integer getBureoIdByLoginForUser(String email, String password);

}
