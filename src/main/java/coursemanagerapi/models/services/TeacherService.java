package coursemanagerapi.models.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import coursemanagerapi.models.entities.Teacher;

@Service
public class TeacherService extends BaseService<Teacher, Long, JpaRepository<Teacher,Long>> {

}
