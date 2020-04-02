package coursemanagerapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coursemanagerapi.models.entities.Payment;
import coursemanagerapi.models.services.PaymentService;

@RestController
@RequestMapping(value = "payments")
public class PaymentController extends BaseController<Payment, PaymentService> {

	@Autowired
	private PaymentService paymentService;
	
	@Override
	public ResponseEntity<List<Payment>> findAll() {
		List<Payment> list = paymentService.getAllPaymentsWithEnrollment();
		return list.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(list);
	}
}
