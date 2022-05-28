package com.example.server.chat.auth;

import java.util.Set;

public class AuthService {

    private static Set<User> USERS = Set.of(
            new User("login1", "password1", "username1"),
            new User("login2", "password2", "username2"),
            new User("login3", "password3", "username3")
    );

    public String getUserNameByLoginAndPassword(String login, String password) {
        User required = new User(login, password);
        for (User user : USERS) {
            if (required.equals(user)) {
                return user.getUsername();
            }
        }

        return null;
    }
}
