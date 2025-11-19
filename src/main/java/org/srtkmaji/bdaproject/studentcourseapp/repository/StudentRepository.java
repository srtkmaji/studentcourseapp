package org.srtkmaji.bdaproject.studentcourseapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.srtkmaji.bdaproject.studentcourseapp.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s JOIN s.course c WHERE c.title = :title")
    List<Student> findStudentsByCourseTitle(@Param("title") String title);
}
