package coursemanagerapi.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coursemanagerapi.models.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
