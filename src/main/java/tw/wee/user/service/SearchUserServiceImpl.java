package tw.wee.user.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.wee.user.domain.User;
import tw.wee.user.entity.UserProfile;
import tw.wee.user.exception.PasswordValidationExpection;
import tw.wee.user.exception.UserNotExistException;
import tw.wee.user.repository.UserRepository;
import tw.wee.user.translator.UserTranslator;

import javax.transaction.Transactional;
import java.security.InvalidParameterException;

import static java.lang.String.format;
import static tw.wee.user.Utils.ErrorMessage.USER_NOT_FOUND_ERROR_MESSAGE;

@Service
@Transactional
public class SearchUserServiceImpl implements SearchUserService {
    final static Logger logger = Logger.getLogger(SearchUserServiceImpl.class);

    @Autowired
    private UserRepository userRespository;
    @Autowired
    private UserTranslator userTranslator;

    @Override
    public User findById(Integer id) {
        UserProfile user = userRespository.findByUserId(id);
        handleUserNotFound(user);
        return userTranslator.translateToDomain(user);
    }

    @Override
    public User findByNameAndPassword(String name, String password) {
        UserProfile user = userRespository.findByName(name);
        handleUserNotFound(user);
        if(!user.getPassword().equals(password)){
            throw new PasswordValidationExpection("Password Not Right");
        }
        return userTranslator.translateToDomain(user);
    }

    @Override
    public User findByParams(String name, String email, String mobile) {
        if(name != null){
            UserProfile user = userRespository.findByName(name);
            handleUserNotFound(user);
            return userTranslator.translateToDomain(user);
        }
        if(email !=null){
            UserProfile user = userRespository.findByEmail(email);
            handleUserNotFound(user);
            return userTranslator.translateToDomain(user);
        }
        if (mobile != null){
            UserProfile user = userRespository.findByMobile(mobile);
            handleUserNotFound(user);
            return userTranslator.translateToDomain(user);
        }
        throw new InvalidParameterException("Insufficient search parameters");
    }


    private void handleUserNotFound(UserProfile user) {
        if(user ==null){
            throw new UserNotExistException(format(USER_NOT_FOUND_ERROR_MESSAGE));
        }
    }
}
