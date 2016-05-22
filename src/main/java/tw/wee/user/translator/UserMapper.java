package tw.wee.user.translator;

import org.springframework.stereotype.Component;
import tw.wee.user.domain.User;
import tw.wee.user.entity.UserProfile;

@Component
public class UserMapper extends BaseMapper{
    public UserMapper(){
        register(UserProfile.class, User.class);
    }
}
