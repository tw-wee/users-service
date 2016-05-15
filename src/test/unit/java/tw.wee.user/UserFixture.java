package tw.wee.user;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import tw.wee.user.domain.User;
import tw.wee.user.entity.UserProfile;
import tw.wee.user.enumeration.Gender;

public class UserFixture {
    public static final DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-mm-dd");

    public static User createUser() {
        User user = new User();
        user.setEmail("test@test.com");
        user.setGender(Gender.FEMALE);
        user.setPassword("test1");
        user.setName("testT");
        user.setBirth(formatter.parseLocalDate("1990-01-02"));
        return user;
    }

    public static UserProfile createUserProfile() {
        UserProfile userProfile = new UserProfile();
        userProfile.setEmail("test@test.com");
        userProfile.setGender(Gender.FEMALE.getValue());
        userProfile.setPassword("test1");
        userProfile.setName("testT");
        userProfile.setBirth(formatter.parseLocalDate("1990-01-02"));
        return userProfile;
    }

}
