package com.jwt.secqurity.jwt.repository;

import com.jwt.secqurity.jwt.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, String> {
}
