package coursemanagerapi.models.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import coursemanagerapi.models.entities.Course;

@Service
public class CourseService extends BaseService<Course, Long, JpaRepository<Course, Long>> {

}
