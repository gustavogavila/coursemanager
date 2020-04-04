package coursemanagerapi.models.specifications;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;

import coursemanagerapi.models.entities.PaymentView;

public class PaymentViewSpecificationBuilder {

	private final List<SpecSearchCriteria> params;

	public PaymentViewSpecificationBuilder() {
		params = new ArrayList<SpecSearchCriteria>();
	}
	
	public PaymentViewSpecificationBuilder with(String orPredicate, String key, String operation, Object value) {
		SearchOperation op = SearchOperation.getSimpleOperation(operation.charAt(0));
		params.add(new SpecSearchCriteria(orPredicate, key, op, value));
		return this;
	}
	
	public Specification<PaymentView> build() {
		
		if (params.size() == 0) {
			return null;
		}
		
		List<PaymentViewSpecification> specs = params.stream().map(PaymentViewSpecification::new).collect(Collectors.toList());
		
		Specification<PaymentView> result = specs.get(0);
		
		for (int i = 1; i < params.size(); i++) {
            result = params.get(i).isOrPredicate()
              ? Specification.where(result).or(new PaymentViewSpecification(params.get(i))) 
              : Specification.where(result).and(new PaymentViewSpecification(params.get(i)));
        }
        
        return result;
	}
	
	
	
	
}
