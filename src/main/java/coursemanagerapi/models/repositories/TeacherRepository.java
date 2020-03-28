package coursemanagerapi.models.repositories;

import org.springframework.data.repository.CrudRepository;

import coursemanagerapi.models.entities.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Long>{

}
