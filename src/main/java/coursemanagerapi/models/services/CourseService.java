package coursemanagerapi.models.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import coursemanagerapi.models.dtos.CourseDTO;
import coursemanagerapi.models.entities.Course;

@Service
public class CourseService extends BaseService<Course, CourseDTO, Long, JpaRepository<Course, Long>> {

	@Override
	public Course fromDTO(CourseDTO objDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
