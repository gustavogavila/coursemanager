package coursemanagerapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coursemanagerapi.models.entities.Payment;
import coursemanagerapi.models.services.PaymentService;

@RestController
@RequestMapping(value = "payments")
public class PaymentController extends BaseController<Payment, PaymentService> {

}
