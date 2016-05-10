package tw.wee.user.translator;

import org.springframework.stereotype.Component;
import tw.wee.user.domain.User;
import tw.wee.user.entity.UserProfile;

@Component
public class UserTranslator {
    public UserProfile translateToProfile(User user) {
        UserProfile userProfile = new UserProfile();
        userProfile.setName(user.getName());
        userProfile.setEmail(user.getEmail());
        userProfile.setBirth(user.getBirth());
        userProfile.setGender(user.getGender());
        userProfile.setPassword(user.getPassword());
        return userProfile;
    }

    public User translateToDomain(UserProfile createdUser) {
        User user = new User();
        user.setUserId(createdUser.getUserId());
        user.setName(createdUser.getName());
        user.setBirth(createdUser.getBirth());
        user.setGender(createdUser.getGender());
        user.setEmail(createdUser.getEmail());
        return user;
    }
}