package tw.wee.user.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import tw.wee.user.UserFixture;
import tw.wee.user.domain.User;
import tw.wee.user.entity.UserProfile;
import tw.wee.user.repository.UserRepository;
import tw.wee.user.translator.UserTranslator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;
import static tw.wee.user.UserFixture.createUser;

@RunWith(MockitoJUnitRunner.class)
public class AddUserServiceImplTest {

    private AddUserService addUserService;

    @Mock
    private UserTranslator userTranslator;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        addUserService = new AddUserServiceImpl();
        setField(addUserService,"userRespository", userRepository);
        setField(addUserService,"userTranslator", userTranslator);
    }

    @Test
    public void testTestShouldSaveUserSuccessfully() throws Exception {
        User inputUser = createUser();
        UserProfile userProfile = UserFixture.createUserProfile();
        UserProfile returnedUserProfile = UserFixture.createUserProfile();
        when(userTranslator.translateToProfile(inputUser)).thenReturn(userProfile);
        when(userRepository.save(userProfile)).thenReturn(returnedUserProfile);
        when(userTranslator.translateToDomain(returnedUserProfile)).thenReturn(createUser());

        User createUser = addUserService.createUser(inputUser);

        assertThat(createUser.getName(),is(inputUser.getName()));


    }
}