package com.jwt.secqurity.jwt.repository;

import com.jwt.secqurity.jwt.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends CrudRepository<Role, String> {

}
