package com.ajinkya.major.repository;

import com.ajinkya.major.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
