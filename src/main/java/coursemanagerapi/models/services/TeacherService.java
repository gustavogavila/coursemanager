package coursemanagerapi.models.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import coursemanagerapi.models.dtos.TeacherDTO;
import coursemanagerapi.models.entities.Teacher;

@Service
public class TeacherService extends BaseService<Teacher, Long, JpaRepository<Teacher,Long>> {

	public Teacher fromDTO(TeacherDTO dto) {
		return new Teacher(dto.getId(), dto.getName(), dto.getEmail(), dto.getPhone());
	}
}
