package coursemanagerapi.models.services;

import org.springframework.stereotype.Service;

import coursemanagerapi.models.entities.Enrollment;
import coursemanagerapi.models.repositories.EnrollmentRepository;

@Service
public class EnrollmentService extends BaseService<Enrollment, Long, EnrollmentRepository> {

}
