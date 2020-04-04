package coursemanagerapi.models.services;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;

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
		int year = date.getYear();
		;

		int durationCourse = 12;

		for (int i = 0; i < durationCourse; i++) {

			LocalDateTime expirationDate = LocalDateTime.of(year, month.getValue(), 10, 23, 59);

			save(new Payment(null, month, Year.of(year), PaymentStatus.PENDING, null, null, expirationDate,
					enrollment));

			if (month == Month.DECEMBER) {
				month = Month.JANUARY;
				year += 1;
			} else {
				month = month.plus(1);
			}

		}

	}
	
	@Override
	public Payment update(Payment entity, Long id) {
		Payment existingEntity = findById(id);
		
		existingEntity.setAmountPaid(entity.getAmountPaid());
		existingEntity.setPayDate(LocalDateTime.now());
		existingEntity.setPaymentStatus(PaymentStatus.PAID);
		
		return repo.save(existingEntity);
	}

}
