package coursemanagerapi.controllers;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import coursemanagerapi.models.entities.Teacher;
import coursemanagerapi.models.services.TeacherService;

@RestController
@RequestMapping(value = "teachers", produces = "application/json")
@CrossOrigin(origins = "*")
public class TeacherController {

	@Autowired
	private TeacherService service;

	@GetMapping("/{id}")
	public ResponseEntity<Teacher> findById(@PathVariable("id") Long id) {
		Teacher teacher = service.findById(id);
		return ResponseEntity.ok().body(teacher);
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<Void> save(@RequestBody Teacher teacher) {
		Teacher obj = service.save(teacher);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody Teacher teacher, @PathVariable("id") Long id) {
		teacher.setId(id);
		teacher = service.update(teacher, id);
		return ResponseEntity.noContent().build();
	}

	
	
	
	@GetMapping
	public ResponseEntity<List<Teacher>> findAll() {
		PageRequest page = PageRequest.of(0, 20, Sort.by("id").descending());
		List<Teacher> list = service.findAll(page);
		return ResponseEntity.ok().body(list);
	}

	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

}
