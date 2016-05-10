package tw.wee.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.wee.user.domain.User;
import tw.wee.user.repository.UserRepository;
import tw.wee.user.translator.UserTranslator;

import javax.transaction.Transactional;

@Service
@Transactional
public class SearchUserServiceImpl implements SearchUserService {
    @Autowired
    private UserRepository userRespository;
    @Autowired
    private UserTranslator userTranslator;

    @Override
    public User findById(Integer id) {
        return userTranslator.translateToDomain(userRespository.findByUserId(id));
    }
}
