package tw.wee.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.wee.user.domain.User;
import tw.wee.user.entity.UserProfile;
import tw.wee.user.repository.UserRepository;
import tw.wee.user.translator.UserTranslator;

@Service
public class AddUserServiceImpl implements AddUserService {
    @Autowired
    private UserRepository userRespository;
    @Autowired
    private UserTranslator userTranslator;

    @Override
    public User createUser(User user) {
        UserProfile createdUser = userRespository.save(userTranslator.translateToProfile(user));
        return userTranslator.translateToDomain(createdUser);
    }
}
