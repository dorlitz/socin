package com.socin.user;

import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence plainTextPassword) {
        return UserService.sha256(plainTextPassword.toString());
    }

    @Override
    public boolean matches(CharSequence plainTextPassword, String passwordInDatabase) {
        String userPassword = plainTextPassword.toString();

        if (null != userPassword && !userPassword.isEmpty() &&
                UserService.sha256(userPassword).equals(passwordInDatabase)) {

            return true;
        } else {
            return false;
        }
    }
}