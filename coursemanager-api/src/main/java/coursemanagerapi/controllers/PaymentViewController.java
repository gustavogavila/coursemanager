package coursemanagerapi.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import coursemanagerapi.models.entities.PaymentView;
import coursemanagerapi.models.services.PaymentViewService;

@RestController
@RequestMapping(value = "paymentsview")
public class PaymentViewController {

	@Autowired
	private PaymentViewService service;

	@GetMapping("/page")
	public ResponseEntity<Page<PaymentView>> findPage(@RequestParam Map<String, String> queryString,
			@RequestParam(value = "search") String search) {
		Page<PaymentView> list = service.findPage(queryString, search);
		return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(list);
	}

}
