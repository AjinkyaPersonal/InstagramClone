package com.geekster.InstagramProject.repo;

import com.geekster.InstagramProject.model.OtpUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOtpRepository extends JpaRepository<OtpUser, Long> {
    OtpUser findFirstByUserEmail(String email);
}
