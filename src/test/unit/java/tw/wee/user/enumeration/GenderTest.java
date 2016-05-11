package tw.wee.user.enumeration;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GenderTest {

    @Test
    public void testGetGender(){
        assertThat(Gender.getGender("F"), is(Gender.FEMALE));
        assertThat(Gender.getGender("M"), is(Gender.MALE));
    }

}