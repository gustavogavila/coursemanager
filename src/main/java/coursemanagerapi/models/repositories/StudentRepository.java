package coursemanagerapi.models.repositories;

import org.springframework.data.repository.CrudRepository;

import coursemanagerapi.models.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{

}
