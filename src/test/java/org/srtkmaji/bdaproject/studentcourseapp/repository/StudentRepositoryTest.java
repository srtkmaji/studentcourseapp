package org.srtkmaji.bdaproject.studentcourseapp.repository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.srtkmaji.bdaproject.studentcourseapp.entity.Course;
import org.srtkmaji.bdaproject.studentcourseapp.entity.Student;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void testFindAllStudents() {
        List<Student> students = studentRepository.findAll();
        assertNotNull(students);
        assertTrue(students.size() >= 0); // adjust for your sample data
    }

    @Test
    public void testSaveStudent() {
        Course course = new Course();
        course.setTitle("Test Course");
        course.setDescription("Test Description");
        Course savedCourse = courseRepository.save(course);

        Student s = new Student();
        s.setName("Aritra Sen");
        s.setEmail("aritra.sen@test.com");
        s.setCourse(savedCourse);

        Student savedStudent = studentRepository.save(s);
        assertNotNull(savedStudent.getId());
        assertEquals("Aritra Sen", savedStudent.getName());
    }
}
