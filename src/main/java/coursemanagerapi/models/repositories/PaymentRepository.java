package coursemanagerapi.models.repositories;

import org.springframework.data.repository.CrudRepository;

import coursemanagerapi.models.entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

}
