package org.srtkmaji.bdaproject.studentcourseapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.srtkmaji.bdaproject.studentcourseapp.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> { }
