package ru.javamentor.pp_3_1_3_springboot.service;

import ru.javamentor.pp_3_1_3_springboot.models.User;

import java.util.List;

public interface UserService {
    List<User> index();
    User show(long id);
    void save(User User);
    void delete(long id);
}
