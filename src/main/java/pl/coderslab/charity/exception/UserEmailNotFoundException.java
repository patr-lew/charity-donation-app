package pl.coderslab.charity.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserEmailNotFoundException extends UsernameNotFoundException {

    public UserEmailNotFoundException(String msg) {
        super(msg);
    }
}
