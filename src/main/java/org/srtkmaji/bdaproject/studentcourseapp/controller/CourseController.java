package org.srtkmaji.bdaproject.studentcourseapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.srtkmaji.bdaproject.studentcourseapp.entity.Course;
import org.srtkmaji.bdaproject.studentcourseapp.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("courses", courseService.findAll());
        return "courses-list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("course", new Course());
        return "course-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Course course) {
        courseService.save(course);
        return "redirect:/courses";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("course", courseService.findById(id).orElse(new Course()));
        return "course-form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
         courseService.delete(id);
            return "redirect:/courses";
        } catch (DataIntegrityViolationException e) {
        // Set error in redirect
        redirectAttributes.addFlashAttribute("errorMessage", "Cannot delete course: students are still enrolled in this course.");
        return "redirect:/courses";
    }
}

}
