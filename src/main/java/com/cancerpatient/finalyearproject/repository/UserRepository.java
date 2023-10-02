package com.cancerpatient.finalyearproject.repository;

import com.cancerpatient.finalyearproject.user.Role;
import com.cancerpatient.finalyearproject.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

//    Optional<User> findByEmailAndRolesIn(String email, Set<Role> roles);
//    @Query("SELECT u FROM User u JOIN u.roles r WHERE r = :roleName")
//    List<User> findUsersByRoleName(String roleName);

}