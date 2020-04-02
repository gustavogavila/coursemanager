package coursemanagerapi.models.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import coursemanagerapi.models.entities.Enrollment;

@Service
public class EnrollmentService extends BaseService<Enrollment, Long, JpaRepository<Enrollment, Long>> {

}
