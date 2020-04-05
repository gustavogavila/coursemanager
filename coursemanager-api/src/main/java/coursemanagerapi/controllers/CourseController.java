package coursemanagerapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coursemanagerapi.models.entities.Course;
import coursemanagerapi.models.services.CourseService;

@RestController
@RequestMapping(value = "courses")
public class CourseController extends BaseController<Course, CourseService> {

}
