package com.geekster.InstagramProject.repo;

import com.geekster.InstagramProject.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepo extends JpaRepository<Admin, Long> {
}
