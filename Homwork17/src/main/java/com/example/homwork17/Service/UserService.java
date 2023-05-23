package com.example.homwork17.Service;

import com.example.homwork17.Model.User;
import com.example.homwork17.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

   public List<User> getAllUser(){
       return userRepository.findAll();
   }
   public void addUser(User user){
       userRepository.save(user);
   }

   public boolean updateUser(Integer id ,User user){
       User oldUser=userRepository.findUserById(id);
       if (oldUser==null){
           return false;
       }

       oldUser.setId(user.getId());
       oldUser.setAge(user.getAge());
       oldUser.setName(user.getName());
       oldUser.setUsername(user.getUsername());
       oldUser.setPassword(user.getPassword());
       oldUser.setRole(user.getRole());
       oldUser.setEmail(user.getEmail());

       userRepository.save(oldUser);
       return true;
   }

   public boolean deleteUser (Integer id){
       User oldUser=userRepository.findUserById(id);
       if(oldUser==null){
           return false;
       }
       userRepository.delete(oldUser);
       return true;
   }

   public User findUserById(Integer id){
       User user=userRepository.findUserById(id);
       if(user==null){
           throw new ArithmeticException("not found");
       }
       return user;
   }
   public User getUserByUsernameAndPassword (String username,String password){
       User user=userRepository.findUserByUsernameAndPassword(username,password);
       if(user==null){
           throw new ArithmeticException("not found");
       }
       return user;
   }

   public User findUserByEmail(String email){
       User user=userRepository.findUserByEmail(email);
       if (user==null){
          throw new ArithmeticException("not found") ;
       }
       return user;
   }

   public List<User> getUserByRole(String role){
       List<User> users=userRepository.findAllUserByRole(role);
       if(users==null){
           throw new ArithmeticException("not found");
       }
       return users;
   }

   public List<User> getUserByAgeGreaterThanEqual(Integer age){
       List<User> users=userRepository.findAllUserByAgeGreaterThanEqual(age);
       if (users==null){
           throw new ArithmeticException("not found");
       }
       return users;
   }

}
