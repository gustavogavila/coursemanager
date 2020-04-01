package coursemanagerapi.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "courses", produces = "application/json")
@CrossOrigin(origins = "*")
public class CourseController {
	
//	@Autowired
//	private CourseService service;
//
//	@GetMapping
//	public List<Course> findAll() {
//		PageRequest page = PageRequest.of(0, 20, Sort.by("id").descending());
//		return service.findAll(page);
//	}
//
//	@GetMapping("/{id}")
//	public ResponseEntity<Course> findById(@PathVariable("id") Long id) {
//		Course course = service.findById(id);
//		if (course != null) {
//			return new ResponseEntity<>(course, HttpStatus.OK);
//		}
//		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//	}
//
//	@PostMapping(consumes = "application/json")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Course save(@RequestBody Course course) {
//		return service.save(course);
//	}
//
//	@PutMapping("/{id}")
//	@ResponseStatus(HttpStatus.OK)
//	public Course update(@PathVariable("id") Long id, @RequestBody Course course) {
//		course.setId(id);
//		return service.update(course, id);
//	}
//
//	@DeleteMapping("/{id}")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public void delete(@PathVariable("id") Long id) {
//		service.delete(id);
//	}

}
