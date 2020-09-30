package vn.codegym.service;

import vn.codegym.model.Course;

public interface CourseService {
    Iterable<Course> findAll();

    void save(Course course);

    Course findById(long id);
}
