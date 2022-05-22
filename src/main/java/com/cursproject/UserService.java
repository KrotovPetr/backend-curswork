package com.cursproject;
import com.cursproject.Entity.Role;
import com.cursproject.Entity.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final List<User> users;

    public UserService() {
        this.users = List.of(
                new User("peter", "1234", "Peter", "Krotov", Collections.singleton(Role.USER))
        );
    }

    public Optional<User> getByLogin(@NonNull String login) {
        return users.stream()
                .filter(user -> login.equals(user.getLogin()))
                .findFirst();
    }

}

//{
//        "login":"peter",
//        "password":"1234"
//        }