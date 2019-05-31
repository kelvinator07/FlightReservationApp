package com.geekykel.flightreservation.repos;

import com.geekykel.flightreservation.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by GeekyKel on 5/24/2019
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
