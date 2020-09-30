package com.codegym.demo.repository;

import com.codegym.demo.model.ClassName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<ClassName, Long> {
}
