package coursemanagerapi.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

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
	
	public E update(E entity, T id) {
		findById(id);
		return repo.save(entity);
	}
	
	public void delete(T id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public List<E> findAll(PageRequest page) {
		return repo.findAll(page).getContent();
	}
	
}
