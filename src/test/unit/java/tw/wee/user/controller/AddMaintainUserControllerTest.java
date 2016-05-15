package tw.wee.user.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import tw.wee.user.domain.User;
import tw.wee.user.exception.InvalidUserException;
import tw.wee.user.service.AddUserService;
import tw.wee.user.service.AddUserServiceImpl;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;
import static tw.wee.user.UserFixture.createUser;

@RunWith(MockitoJUnitRunner.class)
public class AddMaintainUserControllerTest {
    private AddMaintainUserController addMaintainUserController;

    @Mock
    private AddUserService service = new AddUserServiceImpl();

    @Before
    public void setUp() throws Exception {
        addMaintainUserController = new AddMaintainUserController();
        setField(addMaintainUserController, "addUserService", service);
    }

    @Test
    public void testShouldCreateUserSuccessfully() throws Exception {

        User inputUser = createUser();
        User user = createUser();
        user.setUserId(8);
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(false);
        when(service.createUser(inputUser)).thenReturn(user);

        ResponseEntity result = addMaintainUserController.addUser(inputUser, bindingResult);

        assertThat(result.getStatusCode(),is(HttpStatus.CREATED));

    }

    @Test(expected = InvalidUserException.class)
    public void testShouldFailedCreateUserWithInvalidUser() throws Exception {
        User inputUser = createUser();
        inputUser.setEmail("email");
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(true);

        ResponseEntity result = addMaintainUserController.addUser(inputUser, bindingResult);

        assertThat(result.getStatusCode(),is(HttpStatus.BAD_REQUEST));

    }


}