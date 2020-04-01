package coursemanagerapi.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import coursemanagerapi.models.dtos.TeacherDTO;
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
	public ResponseEntity<Void> save(@Valid @RequestBody TeacherDTO objDTO) {
		Teacher obj = service.fromDTO(objDTO);
		obj = service.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody TeacherDTO objDTO, @PathVariable("id") Long id) {
		Teacher obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj, id);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<TeacherDTO>> findAll() {
		List<Teacher> list = service.findAll();
		List<TeacherDTO> dtoList = list.stream().map(obj -> new TeacherDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(dtoList);
	}

	@GetMapping("/page")
	public ResponseEntity<Page<TeacherDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy) {
		Page<Teacher> list = service.findPage(page, linesPerPage, direction, orderBy);
		Page<TeacherDTO> dtoList = list.map(obj -> new TeacherDTO(obj));
		return ResponseEntity.ok().body(dtoList);
	}

}
