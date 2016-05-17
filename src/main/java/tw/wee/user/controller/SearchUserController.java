package tw.wee.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tw.wee.user.domain.User;
import tw.wee.user.service.SearchUserService;

import java.security.InvalidParameterException;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/users")
@Api(tags = "User Resource", description = "Operations on User")
public class SearchUserController {
    final static Logger logger = Logger.getLogger(SearchUserController.class);

    @Autowired
    private SearchUserService searchUserService;

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}")
    @ApiOperation(value = "Retrieve user", notes = "Get User")
    public ResponseEntity getCustomerById(@PathVariable @ApiParam(value = "userId", required = true) int userId) {
        User responseUser = searchUserService.findById(userId);
        return new ResponseEntity<>(responseUser, OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Find user", notes = "Find User")
    public ResponseEntity findCustomer(@RequestParam (required = false) @ApiParam(value = "name") String name,
                                       @RequestParam (required = false) @ApiParam(value = "email") String email,
                                       @RequestParam (required = false) @ApiParam(value = "mobile") String mobile) {
        User responseUser = searchUserService.findByParams(name, email, mobile);
        return new ResponseEntity<>(responseUser, OK);
    }

    private void rejectInvalidUser(BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            throw new InvalidParameterException("Invalid parameters:"+  bindingResult.getFieldErrors());
        }
    }
}
