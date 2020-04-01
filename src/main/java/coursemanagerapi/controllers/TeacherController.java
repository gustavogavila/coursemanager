package coursemanagerapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import coursemanagerapi.models.entities.Teacher;
import coursemanagerapi.models.services.TeacherService;

@RestController
@RequestMapping(value = "teachers", produces = "application/json")
@CrossOrigin(origins = "*")
public class TeacherController {

	@Autowired
	private TeacherService service;

	@GetMapping
	public List<Teacher> findAll() {
		PageRequest page = PageRequest.of(0, 20, Sort.by("id").descending());
		return service.findAll(page);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Teacher> findById(@PathVariable("id") Long id) {
		Teacher teacher = service.findById(id);
		return ResponseEntity.ok().body(teacher);
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Teacher save(@RequestBody Teacher teacher) {
		return service.save(teacher);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Teacher update(@PathVariable("id") Long id, @RequestBody Teacher teacher) {
		teacher.setId(id);
		return service.update(teacher);
//		return courseRepo.findById(id).map(c -> {
//			c.setName(course.getName());
//			c.setDescription(course.getDescription());
//			return courseRepo.save(c);
//		}).orElseGet(() -> {
//			course.setId(id);
//			return courseRepo.save(course);
//		});		
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

}
