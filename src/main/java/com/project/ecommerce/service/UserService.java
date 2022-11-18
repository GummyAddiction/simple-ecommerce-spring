package com.project.ecommerce.service;

import com.project.ecommerce.model.User;
import com.project.ecommerce.model.UserRequest;
import com.project.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public String login(UserRequest usr){
        if(usr.getPassword()!=null || usr.getUsername()!=null){
            User usrDb = userRepository.findByUsername(usr.getUsername());

            if(usrDb!=null){
                if(bCryptPasswordEncoder.matches(usr.getPassword(), usrDb.getPassword()) == true){
                    return usrDb.getRole();
                }
            }
        }
        return "";
    }
}
