package tw.wee.user.service;


import tw.wee.user.domain.User;

public interface SearchUserService {
    User findById(Integer id);

    User findByParams(String name, String email, String tel);
}
