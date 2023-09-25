package com.ajinkya.major.repository;

import com.ajinkya.major.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer > {
}
