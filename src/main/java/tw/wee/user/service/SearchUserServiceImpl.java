package tw.wee.user.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.wee.user.domain.User;
import tw.wee.user.entity.UserProfile;
import tw.wee.user.exception.UserNotExistException;
import tw.wee.user.repository.UserRepository;
import tw.wee.user.translator.UserTranslator;

import javax.transaction.Transactional;

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
        UserProfile byUserId = userRespository.findByUserId(id);
        if (byUserId == null) {
            throw new UserNotExistException(format(USER_NOT_FOUND_ERROR_MESSAGE,id));
        }
        return userTranslator.translateToDomain(byUserId);
    }

    @Override
    public User findByParams(String name, String email, String tel) {
        UserProfile profile = null;
        if(name != null){
             profile = userRespository.findByName(name);
        }
        return userTranslator.translateToDomain(profile);
    }
}
