package coursemanagerapi.models.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coursemanagerapi.models.entities.Student;
import coursemanagerapi.models.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	public Student findById(Long id) {
		Optional<Student> opt = studentRepo.findById(id);
		return opt.orElse(null);
	}
	
}
