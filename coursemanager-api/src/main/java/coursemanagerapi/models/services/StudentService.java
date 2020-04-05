package coursemanagerapi.models.services;

import org.springframework.stereotype.Service;

import coursemanagerapi.models.entities.Student;
import coursemanagerapi.models.repositories.StudentRepository;

@Service
public class StudentService extends BaseService<Student, Long, StudentRepository> {

}
