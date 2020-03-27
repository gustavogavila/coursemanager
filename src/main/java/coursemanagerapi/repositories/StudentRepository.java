package coursemanagerapi.repositories;

import org.springframework.data.repository.CrudRepository;

import coursemanagerapi.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{

}
