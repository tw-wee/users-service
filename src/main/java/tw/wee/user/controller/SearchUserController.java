package tw.wee.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tw.wee.user.domain.User;
import tw.wee.user.service.SearchUserService;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/users")
public class SearchUserController {

    @Autowired
    private SearchUserService searchUserService;

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}")
    public ResponseEntity findCustomerById(@PathVariable(value = "userId") int userId) {
        User responseUser = searchUserService.findById(userId);
        return new ResponseEntity<>(responseUser, OK);
    }

}
