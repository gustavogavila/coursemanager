package coursemanagerapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coursemanagerapi.models.entities.Student;
import coursemanagerapi.models.services.StudentService;

@RestController
@RequestMapping(value = "students")
public class StudentController extends BaseController<Student, StudentService> {


}
