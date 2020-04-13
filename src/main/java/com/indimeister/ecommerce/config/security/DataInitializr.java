package com.indimeister.ecommerce.config.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.indimeister.ecommerce.model.Role;
import com.indimeister.ecommerce.model.User;
import com.indimeister.ecommerce.repository.RoleRepository;
import com.indimeister.ecommerce.repository.UserRepository;
import com.indimeister.ecommerce.util.Const;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {

             
//        if (users.isEmpty()) {
            createUser("Admin", "admin", passwordEncoder.encode("123456"), Const.ROLE_ADMIN);
            createUser("Cliente", "cliente", passwordEncoder.encode("123456"), Const.ROLE_CLIENT);
//        }else{
//            List<User> users = userRepository.findAll();      
//          
//          Role role = new Role(Const.ROLE_ADMIN);
//          this.roleRepository.save(role);      
//          users.get(0).setRoles(Arrays.asList(role));
//          userRepository.save(users.get(0));     
//    }

    }

    public void createUser(String name, String email, String password, String roleName) {

        Role role = new Role(roleName);

        this.roleRepository.save(role);
        User user = new User(name, email, password, Arrays.asList(role));
        userRepository.save(user);
    }



}
