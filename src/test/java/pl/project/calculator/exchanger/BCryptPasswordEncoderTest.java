package pl.project.calculator.exchanger;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderTest {
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Test
    public void shouldMatchWithEncodedPassword() {
        String password = "SecretPassword";
        String encodedPassword = bCryptPasswordEncoder.encode(password);

        Assert.assertTrue(bCryptPasswordEncoder.matches(password, encodedPassword));
    }
}
