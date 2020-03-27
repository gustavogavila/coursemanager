package coursemanagerapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

import coursemanagerapi.models.Course;
import coursemanagerapi.repositories.CourseRepository;

@RestController
@RequestMapping(value = "courses", produces = "application/json")
@CrossOrigin(origins = "*")
public class CourseController {

	@Autowired
	private CourseRepository courseRepo;

	@GetMapping
	public List<Course> findAll() {
		PageRequest page = PageRequest.of(0, 20, Sort.by("id").descending());
		return courseRepo.findAll(page).getContent();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Course> findById(@PathVariable("id") Long id) {
		Optional<Course> optCourse = courseRepo.findById(id);
		if (optCourse.isPresent()) {
			return new ResponseEntity<>(optCourse.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Course save(@RequestBody Course course) {
		return courseRepo.save(course);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Course update(@PathVariable("id") Long id, @RequestBody Course course) {
		return courseRepo.findById(id).map(c -> {
			c.setName(course.getName());
			c.setDescription(course.getDescription());
			return courseRepo.save(c);
		}).orElseGet(() -> {
			course.setId(id);
			return courseRepo.save(course);
		});
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		try {
			courseRepo.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
		}
	}

}
