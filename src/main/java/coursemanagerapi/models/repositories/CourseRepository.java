package coursemanagerapi.models.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import coursemanagerapi.models.entities.Course;

public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {

}
