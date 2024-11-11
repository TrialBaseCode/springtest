package com.example.spring.repositry;

import com.example.spring.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepositry extends JpaRepository<Category, Integer> {
    Optional<Category> findByName(String name);
}
