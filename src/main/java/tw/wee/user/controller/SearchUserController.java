package tw.wee.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tw.wee.user.domain.User;
import tw.wee.user.service.SearchUserService;

import javax.validation.Valid;

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
    @ApiOperation(value = "Retrieve user", notes = "Get User")
    public ResponseEntity findCustomer(@PathVariable @Valid @ApiParam(value = "name") String name,
                                       @PathVariable @Valid @ApiParam(value = "email") String email,
                                       @PathVariable @Valid @ApiParam(value = "tel") String tel) {

        User responseUser = searchUserService.findByParams(name, email, tel);
        return new ResponseEntity<>(responseUser, OK);
    }

}
