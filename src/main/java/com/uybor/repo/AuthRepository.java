package com.uybor.repo;

import com.uybor.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;


public interface AuthRepository extends JpaRepository<User, UUID> {

    @Query(nativeQuery = true ,value = "SELECT * from users where username =?1")
    boolean existUserByUserName(String userName);
}
