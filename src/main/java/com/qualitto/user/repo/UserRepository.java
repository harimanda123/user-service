package com.qualitto.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qualitto.user.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
