package ru.javamentor.pp_3_1_3_springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.javamentor.pp_3_1_3_springboot.models.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
}
