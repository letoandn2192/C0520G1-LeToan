package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
