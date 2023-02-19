package com.jwt.secqurity.jwt.service;


import com.jwt.secqurity.jwt.entity.Role;
import com.jwt.secqurity.jwt.entity.User;
import com.jwt.secqurity.jwt.repository.RoleDao;
import com.jwt.secqurity.jwt.repository.UserDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleDao.save(userRole);



        Role roleAdmin = new Role();
        roleAdmin.setRoleName("ROLE_ADMIN");
        roleAdmin.setRoleDescription("Default role for newly ROLE_ADMIN record");
        roleDao.save(roleAdmin);



        Role roleMODERATOR = new Role();
        roleMODERATOR.setRoleName("ROLE_MODERATOR");
        roleMODERATOR.setRoleDescription("Default role for newly ROLE_MODERATOR record");
        roleDao.save(roleMODERATOR);

        User adminUser = new User();
        adminUser.setUserName("admin123");
        adminUser.setPassword(getEncodedPassword("admin@pass"));
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setEmail("admin@gmail.com");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(roleAdmin);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

//        User user = new User();
//        user.setUserName("raj123");
//        user.setUserPassword(getEncodedPassword("raj@123"));
//        user.setUserFirstName("raj");
//        user.setUserLastName("sharma");
//        Set<Role> userRoles = new HashSet<>();
//        userRoles.add(userRole);
//        user.setRole(userRoles);
//        userDao.save(user);
    }

    public User registerNewUser(User user) {

        Role role = roleDao.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setPassword(getEncodedPassword(user.getPassword()));

        return userDao.save(user);
    }

    public User updateUser(User user) {
        Optional<User> optionalUser  = userDao.findById(user.getUsername());

        if (optionalUser.isPresent()){
            Set<Role> userRoles = new HashSet<>();
            userRoles.addAll(optionalUser.get().getRole());
            userRoles.addAll(user.getRole());
            optionalUser.get().setRole(userRoles);
            return userDao.save( optionalUser.get());

        }
        return null;
    }


    public Iterable<User> getAll() {


        return userDao.findAll();
    }
    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }


}
