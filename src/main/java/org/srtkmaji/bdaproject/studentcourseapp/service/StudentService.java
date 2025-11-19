package org.srtkmaji.bdaproject.studentcourseapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.srtkmaji.bdaproject.studentcourseapp.entity.Student;
import org.srtkmaji.bdaproject.studentcourseapp.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repo;

    public List<Student> findAll() { 
        return repo.findAll(); 
    }

    public Student save(Student s) { 
        return repo.save(s); 
    }

    // Add this method:
    public Optional<Student> findById(Long id) { 
        return repo.findById(id); 
    }

    public void delete(Long id) { 
        repo.deleteById(id); 
    }
}
