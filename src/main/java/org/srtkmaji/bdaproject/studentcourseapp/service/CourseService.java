package org.srtkmaji.bdaproject.studentcourseapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.srtkmaji.bdaproject.studentcourseapp.entity.Course;
import org.srtkmaji.bdaproject.studentcourseapp.repository.CourseRepository;

@Service
public class CourseService {
    @Autowired
    private CourseRepository repo;

    public List<Course> findAll() { 
        return repo.findAll(); 
    }

    public Course save(Course c) { 
        return repo.save(c); 
    }

    public Optional<Course> findById(Long id) { 
        return repo.findById(id); 
    }

    public void delete(Long id) { 
        repo.deleteById(id); 
    }
}
