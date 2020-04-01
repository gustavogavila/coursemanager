package coursemanagerapi.models.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import coursemanagerapi.models.dtos.StudentDTO;
import coursemanagerapi.models.entities.Student;

@Service
public class StudentService extends BaseService<Student, StudentDTO, Long, JpaRepository<Student, Long>> {

	@Override
	public Student fromDTO(StudentDTO objDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
