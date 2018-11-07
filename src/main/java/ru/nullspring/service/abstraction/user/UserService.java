package ru.nullspring.service.abstraction.user;

import ru.nullspring.model.User;

import java.util.List;

public interface UserService {
    long saveUser(User user);

    User getUserById(long id);

    void editUser(User user);

    void deleteUser(long id);

    List<User> getAllUsers();

    User getUserByLogin(String login);
}
