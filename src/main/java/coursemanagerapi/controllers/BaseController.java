package coursemanagerapi.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import coursemanagerapi.models.services.BaseService;

@CrossOrigin
@SuppressWarnings(value = { "rawtypes", "unchecked" })
public abstract class BaseController<E, S extends BaseService> {

	@Autowired
	protected S service;

	@GetMapping("/{id}")
	public ResponseEntity<E> findById(@PathVariable("id") Long id) {
		E entity = (E) service.findById(id);
		return ResponseEntity.ok().body(entity);
	}

	@PostMapping
	public ResponseEntity<E> save(@Valid @RequestBody E entity) {
		entity = (E) service.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entity);
	}

	@PutMapping("/{id}")
	public ResponseEntity<E> update(@Valid @RequestBody E entity, @PathVariable("id") Long id) {
		entity = (E) service.update(entity, id);
		return ResponseEntity.ok(entity);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<E>> findAll() {
		List<E> list = service.findAll();
		return list.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(list);
	}

	@GetMapping("/page")
	public ResponseEntity<Page<E>> findPage(@RequestParam Map<String, String> queryString, Pageable pageable) {
		Page<E> list = service.findPage(queryString, pageable);
		return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(list);
	}

}
