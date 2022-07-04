package ru.javamentor.pp_3_1_3_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentor.pp_3_1_3_springboot.dao.UserDAO;
import ru.javamentor.pp_3_1_3_springboot.models.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> index() {
        return userDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User show(long id) {
        return userDAO.findById(id).get();
    }

    @Override
    public void save(User User) {
        userDAO.save(User);
    }

    @Override
    public void delete(long id) {
        userDAO.deleteById(id);
    }
}
