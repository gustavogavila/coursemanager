package coursemanagerapi.controllers;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import coursemanagerapi.models.entities.PaymentView;
import coursemanagerapi.models.repositories.PaymentViewRepository;
import coursemanagerapi.models.services.PaymentViewService;
import coursemanagerapi.models.specifications.PaymentViewSpecificationBuilder;

@RestController
@RequestMapping(value = "paymentsview")
public class PaymentViewController extends BaseController<PaymentView, PaymentViewService> {

	@Autowired
	private PaymentViewRepository repo;
	
    @GetMapping("/busca")
    public List<PaymentView> search(@RequestParam(value = "search") String search) {
    	PaymentViewSpecificationBuilder builder = new PaymentViewSpecificationBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            builder.with(null, matcher.group(1), matcher.group(2), matcher.group(3));
        }
         
        Specification<PaymentView> spec = builder.build();
        return repo.findAll(spec);
    }
}
