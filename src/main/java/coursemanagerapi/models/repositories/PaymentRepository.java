package coursemanagerapi.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coursemanagerapi.models.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
