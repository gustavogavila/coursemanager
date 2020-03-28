package coursemanagerapi.models.repositories;

import org.springframework.data.repository.CrudRepository;

import coursemanagerapi.models.entities.Enrollment;

public interface EnrollmentRepository extends CrudRepository<Enrollment, Long> {

}
