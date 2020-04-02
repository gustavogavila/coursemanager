package coursemanagerapi.models.services;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.util.List;

import org.springframework.stereotype.Service;

import coursemanagerapi.models.entities.Enrollment;
import coursemanagerapi.models.entities.Payment;
import coursemanagerapi.models.enums.PaymentStatus;
import coursemanagerapi.models.repositories.PaymentRepository;

@Service
public class PaymentService extends BaseService<Payment, Long, PaymentRepository> {

	public void buildMonthlyPayments(Enrollment enrollment) {

		LocalDateTime date = enrollment.getDate();
		Month month = date.getMonth();
		int year = date.getYear();;
		
		int durationCourse = 12;

		for (int i = 0; i < durationCourse; i++) {
			
			LocalDateTime expirationDate = LocalDateTime.of(year, month.getValue(), 10, 23, 59);
						
			save(new Payment(null, month, Year.of(year), PaymentStatus.PENDING, null, null,
					expirationDate, enrollment));
			
			if (month == Month.DECEMBER) {
				month = Month.JANUARY;
				year += 1;
			} else {
				month = month.plus(1);				
			}
		
		}

	}

	public List<Payment> getAllPaymentsWithEnrollment() {
		return repo.getAllPaymentsWithEnrollment();
	}
	
}
