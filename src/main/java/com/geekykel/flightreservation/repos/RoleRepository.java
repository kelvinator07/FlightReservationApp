package com.geekykel.flightreservation.repos;

import com.geekykel.flightreservation.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by GeekyKel on 5/29/2019
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
