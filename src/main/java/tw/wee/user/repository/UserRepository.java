package tw.wee.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tw.wee.user.entity.UserProfile;

@Repository
public interface UserRepository extends CrudRepository<UserProfile, Integer> {
    UserProfile findByUserId(Integer id);
    UserProfile save(UserProfile user);
}
