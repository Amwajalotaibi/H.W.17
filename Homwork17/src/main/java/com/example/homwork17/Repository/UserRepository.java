package com.example.homwork17.Repository;

import com.example.homwork17.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserById(Integer id);

    User findUserByUsernameAndPassword(String username,String password);

    User findUserByEmail(String email);

    List<User> findAllUserByRole(String role);

    List<User> findAllUserByAgeGreaterThanEqual(Integer age);

}
