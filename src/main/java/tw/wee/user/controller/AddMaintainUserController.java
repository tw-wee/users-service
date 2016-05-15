package tw.wee.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tw.wee.user.domain.User;
import tw.wee.user.exception.InvalidUserException;
import tw.wee.user.service.AddUserService;

import javax.validation.Valid;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/users")
@Api(tags = "User Resource", description = "Operations on User")
public class AddMaintainUserController {
    final static Logger logger = Logger.getLogger(SearchUserController.class);

    @Autowired
    private AddUserService addUserService;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Create a user", notes = "Create a User in user-service")
    @ResponseStatus(value = CREATED)
    public ResponseEntity addUser(@RequestBody @Valid User user, BindingResult bindingResult){
        rejectInvalidUser(bindingResult);
        User createdUser = addUserService.createUser(user);
        logger.debug(format("User is created: %d", createdUser.getUserId()));
        return new ResponseEntity<>(createdUser, CREATED);
    }

    private void rejectInvalidUser(BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            throw new InvalidUserException("Invalid User", bindingResult);
        }
    }
}
