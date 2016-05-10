package tw.wee.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tw.wee.user.domain.User;
import tw.wee.user.exception.InvalidUserException;
import tw.wee.user.service.AddUserService;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/users")
public class AddMaintainUserController {

    @Autowired
    private AddUserService addUserService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity findCustomerById(@RequestBody @Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidUserException("Invalid User", bindingResult);
        }
        return new ResponseEntity(addUserService.createUser(user), CREATED);
    }
}
