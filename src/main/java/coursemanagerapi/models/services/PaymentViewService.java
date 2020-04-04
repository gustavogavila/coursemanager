package coursemanagerapi.models.services;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import coursemanagerapi.controllers.utils.URL;
import coursemanagerapi.models.entities.PaymentView;
import coursemanagerapi.models.repositories.PaymentViewRepository;
import coursemanagerapi.models.specifications.PaymentViewSpecificationBuilder;
import coursemanagerapi.models.specifications.SearchOperation;

@Service
public class PaymentViewService {

	@Autowired
	private PaymentViewRepository repo;

	public Page<PaymentView> findPage(@RequestParam Map<String, String> queryString,
			@RequestParam(value = "search") String search) {
		Integer page = queryString.get("page") != null ? Integer.valueOf(queryString.get("page")) : 0;
		Integer linesPerPage = queryString.get("linesPerPage") != null
				? Integer.valueOf(queryString.get("linesPerPage"))
				: 24;
		String direction = queryString.get("direction") != null ? queryString.get("direction") : "DESC";
		String orderBy = queryString.get("orderBy") != null ? queryString.get("orderBy") : "id";

		PageRequest pageable = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		PaymentViewSpecificationBuilder builder = new PaymentViewSpecificationBuilder();

		search = URL.decodeParam(search);

		List<String> operations = Arrays.asList(SearchOperation.SIMPLE_OPERATION_SET);
		String operationSetExper = operations.stream().reduce("", (s, o) -> s + "|" + o).substring(1);

		Pattern pattern = Pattern.compile(
				"(\\p{Punct}?)(\\w+?)(" + operationSetExper + ")(\\p{Punct}?)((\\w+)(\\s\\w+)?)(\\p{Punct}?),",
				Pattern.UNICODE_CHARACTER_CLASS);

		Matcher matcher = pattern.matcher(search + ",");
		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(5), matcher.group(4),
					matcher.group(6));
		}

		Specification<PaymentView> spec = builder.build();

		return repo.findAll(spec, pageable);

	}

}
