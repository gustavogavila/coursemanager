package coursemanagerapi.repositories;

import org.springframework.data.repository.CrudRepository;

import coursemanagerapi.models.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

}
