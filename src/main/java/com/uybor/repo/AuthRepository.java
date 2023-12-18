package com.uybor.repo;

import com.uybor.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public interface AuthRepository extends JpaRepository<User,UUID> {
}
