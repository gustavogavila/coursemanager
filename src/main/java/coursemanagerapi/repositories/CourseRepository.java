package coursemanagerapi.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import coursemanagerapi.models.Course;

public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {

}
