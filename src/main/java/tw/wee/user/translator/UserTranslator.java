package tw.wee.user.translator;

import org.springframework.stereotype.Component;
import tw.wee.user.domain.User;
import tw.wee.user.entity.UserProfile;
import tw.wee.user.enumeration.Gender;
import tw.wee.user.enumeration.RoleType;

@Component
public class UserTranslator {
    public UserProfile translateToProfile(User user) {
        UserProfile userProfile = new UserProfile();
        userProfile.setName(user.getName());
        userProfile.setEmail(user.getEmail());
        userProfile.setBirth(user.getBirth());
        userProfile.setGender(user.getGender().getValue());
        userProfile.setPassword(user.getPassword());
        userProfile.setMobile(user.getMobile());
        userProfile.setDisacitveIndicator(user.getDisactiveIndicator() == null || true ? 'A' : 'D');
        userProfile.setRole(user.getRole().getValue());
        return userProfile;
    }

    public User translateToDomain(UserProfile createdUser) {
        User user = new User();
        user.setUserId(createdUser.getUserId());
        user.setName(createdUser.getName());
        user.setBirth(createdUser.getBirth());
        user.setGender(Gender.getGender(createdUser.getGender()));
        user.setEmail(createdUser.getEmail());
        user.setMobile(createdUser.getMobile());
        user.setDisactiveIndicator(getIndicator(createdUser.getDisacitveIndicator()));
        user.setRole(RoleType.getRole(createdUser.getRole()));
        return user;
    }

    private Boolean getIndicator(Character indicator) {
        if (indicator.equals('A')) {
            return true;
        } else return false;
    }
}
