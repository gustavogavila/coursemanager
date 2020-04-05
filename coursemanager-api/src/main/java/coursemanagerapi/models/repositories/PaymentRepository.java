package coursemanagerapi.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coursemanagerapi.models.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

//	@Query(value = "SELECT\n" + 
//					"p.id,\n" + 
//					"s.name AS student_name,\n" + 
//					"c.name AS course_name,\n" + 
//					"p.month,\n" + 
//					"p.year,\n" + 
//					"p.expiration_date,\n" + 
//					"p.pay_date,\n" + 
//					"p.amount_paid,\n" + 
//					"p.payment_status\n" + 
//					"FROM payment p\n" + 
//					"LEFT JOIN enrollment e on e.id = p.enrollment_id\n" + 
//					"LEFT JOIN course c on c.id = e.course_id\n" + 
//					"LEFT JOIN student s on s.id = e.student_id",
//			nativeQuery = true
//			)
//	public List<PaymentView> getAllPaymentsWithEnrollment();
}
