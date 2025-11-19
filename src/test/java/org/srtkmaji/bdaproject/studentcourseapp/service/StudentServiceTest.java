package org.srtkmaji.bdaproject.studentcourseapp.repository;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.srtkmaji.bdaproject.studentcourseapp.entity.Student;
import org.srtkmaji.bdaproject.studentcourseapp.repository.StudentRepository;
import org.srtkmaji.bdaproject.studentcourseapp.service.StudentService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StudentServiceTest {

    @Mock
    private StudentRepository repo;

    @InjectMocks
    private StudentService service;

    public StudentServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById() {
        Student s = new Student();
        s.setId(1L);
        s.setName("Sayani Mondal");
        when(repo.findById(1L)).thenReturn(Optional.of(s));

        Optional<Student> found = service.findById(1L);
        assertTrue(found.isPresent());
        assertEquals("Sayani Mondal", found.get().getName());
    }

    @Test
    public void testSaveStudent() {
        Student s = new Student();
        s.setName("Pratik Mondal");
        when(repo.save(s)).thenReturn(s);

        Student saved = service.save(s);
        assertEquals("Pratik Mondal", saved.getName());
    }
}
