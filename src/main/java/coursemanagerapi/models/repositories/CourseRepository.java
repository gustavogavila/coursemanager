package coursemanagerapi.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coursemanagerapi.models.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
