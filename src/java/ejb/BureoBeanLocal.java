package ejb;

import java.util.Collection;
import javax.ejb.Local;
import viewentity.GetAllUsers;

@Local
public interface BureoBeanLocal {

    public Collection<GetAllUsers> getAllUsers();

    public Collection<GetAllUsers> getAllUsersByBureoId(Integer bureoId);

    public void addUserByBureo(Integer bureoId, String firstName, String lastName, String email, String password, String phone,
            String photo, String gender, Integer age, String city, String state, String zipcode, Integer countryId, String eyeColour,
            String hairColour, String height, String education, String maritalStatus, String motherTongue, String lookingFor, String address,
            String salary, String occuption, String workAddress);

    public void updateUserByBureo(Integer userId, Integer userDetailId, Integer bureoId, String firstName, String lastName, String email, String password, String phone,
            String photo, String gender, Integer age, String city, String state, String zipcode, Integer countryId, String eyeColour,
            String hairColour, String height, String education, String maritalStatus, String motherTongue, String lookingFor, String address,
            String salary, String occuption, String workAddress);

    public GetAllUsers getUserByUserById(Integer userId, Integer userDetailId, Integer bureoId);

    public void deleteUser(Integer userId, Integer userDetailId, Integer bureoId);
}
