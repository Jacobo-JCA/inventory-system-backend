package com.softwarelabs.InventorySystem.modules.user.repo;

import com.softwarelabs.InventorySystem.modules.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends GenericRepo<User, Long> {
    @Query("SELECT u FROM User u LEFT JOIN FETCH u.authorities a LEFT JOIN FETCH a.role WHERE u.email = :email")
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}