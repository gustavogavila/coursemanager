package coursemanagerapi.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import coursemanagerapi.models.entities.PaymentView;

@Repository
public interface PaymentViewRepository extends JpaRepository<PaymentView, Long>, JpaSpecificationExecutor<PaymentView> {

}
