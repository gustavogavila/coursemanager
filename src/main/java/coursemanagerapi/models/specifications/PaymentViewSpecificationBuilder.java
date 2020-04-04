package coursemanagerapi.models.specifications;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import coursemanagerapi.models.entities.PaymentView;

public class PaymentViewSpecificationBuilder {

	private final List<SpecSearchCriteria> params;

	public PaymentViewSpecificationBuilder() {
		params = new ArrayList<SpecSearchCriteria>();
	}

	public PaymentViewSpecificationBuilder with(String orPredicate, String key, String operation, Object value,
			String prefix, String sufix) {

		SearchOperation op = SearchOperation.getSimpleOperation(operation.charAt(0));
		params.add(new SpecSearchCriteria(orPredicate, key, op, value, prefix, sufix));
		return this;
	}

	public Specification<PaymentView> build() {

		if (params.size() == 0) {
			return null;
		}

		Specification<PaymentView> result = new PaymentViewSpecification(params.get(0));

		for (int i = 1; i < params.size(); i++) {
			result = params.get(i).isOrPredicate()
					? Specification.where(result).or(new PaymentViewSpecification(params.get(i)))
					: Specification.where(result).and(new PaymentViewSpecification(params.get(i)));
		}

		return result;
	}

}
