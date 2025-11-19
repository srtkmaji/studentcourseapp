package org.srtkmaji.bdaproject.studentcourseapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.srtkmaji.bdaproject.studentcourseapp.entity.Student;
import org.srtkmaji.bdaproject.studentcourseapp.service.StudentService;
import org.srtkmaji.bdaproject.studentcourseapp.service.CourseService;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students-list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
    model.addAttribute("student", new Student());
    model.addAttribute("courses", courseService.findAll()); // Add this line!
    return "student-form";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
    model.addAttribute("student", studentService.findById(id).orElse(new Student()));
    model.addAttribute("courses", courseService.findAll());
    return "student-form";
}

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
    studentService.delete(id);
    return "redirect:/students";
}

}
