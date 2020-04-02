package coursemanagerapi.models.services;

import org.springframework.stereotype.Service;

import coursemanagerapi.models.entities.Teacher;
import coursemanagerapi.models.repositories.TeacherRepository;

@Service
public class TeacherService extends BaseService<Teacher, Long, TeacherRepository> {

}
