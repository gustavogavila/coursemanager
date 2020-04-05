package coursemanagerapi.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coursemanagerapi.models.entities.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
