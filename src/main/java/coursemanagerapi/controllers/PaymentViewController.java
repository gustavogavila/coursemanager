package coursemanagerapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coursemanagerapi.models.entities.PaymentView;
import coursemanagerapi.models.services.PaymentViewService;

@RestController
@RequestMapping(value = "paymentsview")
public class PaymentViewController extends BaseController<PaymentView, PaymentViewService> {

//	@Autowired
//	private PaymentViewService paymentViewService;
//	
//	@Override
//	public ResponseEntity<List<PaymentView>> findAll() {
//		List<PaymentView> list = paymentViewService.getAllPaymentsWithEnrollment();
//		return list.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(list);
//	}
}
