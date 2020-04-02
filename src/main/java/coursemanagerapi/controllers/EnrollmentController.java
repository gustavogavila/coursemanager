package coursemanagerapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coursemanagerapi.models.entities.Enrollment;
import coursemanagerapi.models.services.EnrollmentService;

@RestController
@RequestMapping(value = "enrollments")
public class EnrollmentController extends BaseController<Enrollment, EnrollmentService> {

}
