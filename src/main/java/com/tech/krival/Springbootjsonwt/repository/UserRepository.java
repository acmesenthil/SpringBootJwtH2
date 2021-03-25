package com.tech.krival.Springbootjsonwt.repository;

import com.tech.krival.Springbootjsonwt.model.UserDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface UserRepository extends CrudRepository<UserDao, Integer> {
    UserDao findByUsername(String username);
}