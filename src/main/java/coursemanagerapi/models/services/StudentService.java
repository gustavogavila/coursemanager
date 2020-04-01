package coursemanagerapi.models.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import coursemanagerapi.models.entities.Student;

@Service
public class StudentService extends BaseService<Student, Long, JpaRepository<Student, Long>> {

}
