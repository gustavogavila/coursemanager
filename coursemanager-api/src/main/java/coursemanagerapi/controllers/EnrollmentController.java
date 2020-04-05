package coursemanagerapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coursemanagerapi.models.entities.Enrollment;
import coursemanagerapi.models.services.EnrollmentService;
import coursemanagerapi.models.services.PaymentService;

@RestController
@RequestMapping(value = "enrollments")
public class EnrollmentController extends BaseController<Enrollment, EnrollmentService> {

	@Autowired
	private PaymentService paymentService;
	
	@Override
	protected Enrollment afterSave(Enrollment entity) {
		paymentService.buildMonthlyPayments(entity);
		return entity;
	}
}
