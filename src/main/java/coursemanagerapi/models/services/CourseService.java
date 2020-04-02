package coursemanagerapi.models.services;

import org.springframework.stereotype.Service;

import coursemanagerapi.models.entities.Course;
import coursemanagerapi.models.repositories.CourseRepository;

@Service
public class CourseService extends BaseService<Course, Long, CourseRepository> {

}
