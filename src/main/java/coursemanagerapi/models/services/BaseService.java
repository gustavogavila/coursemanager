package coursemanagerapi.models.services;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import coursemanagerapi.models.exceptions.ObjectNotFoundException;

public abstract class BaseService<E, T, R extends JpaRepository<E, T>> {

	@Autowired
	protected R repo;

	public E findById(T id) {
		Optional<E> opt = repo.findById(id);
		return opt.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}

	public E save(E entity) {
		return repo.save(entity);
	}
	
	public Collection<E> saveAll(Collection<E> entityList) {
		return repo.saveAll(entityList);
	}

	public E update(E entity, T id) {
		E existingEntity = findById(id);
		BeanUtils.copyProperties(entity, existingEntity, "id");
		return repo.save(existingEntity);
	}

	public void deleteById(T id) {
		findById(id);
		repo.deleteById(id);
	}

	public List<E> findAll() {
		return repo.findAll();
	}

	public Page<E> findPage(@RequestParam Map<String, String> queryString) {
		Integer page = queryString.get("page") != null ? Integer.valueOf(queryString.get("page")) : 0;
		Integer linesPerPage = queryString.get("linesPerPage") != null ? Integer.valueOf(queryString.get("linesPerPage")) : 24;
		String direction = queryString.get("direction") != null ? queryString.get("direction") : "DESC";
		String orderBy = queryString.get("orderBy") != null ? queryString.get("orderBy") : "id";
		
		PageRequest pageable = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		return repo.findAll(pageable);
	}

}
