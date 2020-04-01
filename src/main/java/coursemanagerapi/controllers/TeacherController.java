package coursemanagerapi.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coursemanagerapi.models.dtos.TeacherDTO;
import coursemanagerapi.models.entities.Teacher;
import coursemanagerapi.models.services.TeacherService;

@RestController
@RequestMapping(value = "teachers", produces = "application/json")
@CrossOrigin(origins = "*")
public class TeacherController extends BaseController<Teacher, TeacherDTO, TeacherService> {


}
