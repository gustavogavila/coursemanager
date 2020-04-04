package coursemanagerapi.models.specifications;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SpecSearchCriteria {

	private String key;
	private SearchOperation operation;
	private Object value;

	private boolean orPredicate;
	private String prefix;
	private String sufix;

	public SpecSearchCriteria(final String key, final SearchOperation operation, final Object value) {
		super();
		this.key = key;
		this.operation = operation;
		this.value = value;
	}

	public SpecSearchCriteria(final String orPredicate, final String key, final SearchOperation operation,
			final Object value) {
		super();
		this.orPredicate = orPredicate != null && orPredicate.equals(SearchOperation.OR_PREDICATE_FLAG);
		this.key = key;
		this.operation = operation;
		this.value = value;
	}

	public SpecSearchCriteria(final String orPredicate, final String key, final SearchOperation operation,
			final Object value, final String prefix, final String sufix) {
		super();

		this.operation = operation;

		if (operation == SearchOperation.EQUALITY) {
			boolean startWithAsterisk = prefix.contains("*");
			boolean endWithAsterisk = sufix.contains("*");

			if (startWithAsterisk && endWithAsterisk) {
				this.operation = SearchOperation.CONTAINS;
			} else if (startWithAsterisk) {
				this.operation = SearchOperation.ENDS_WITH;
			} else if (endWithAsterisk) {
				this.operation = SearchOperation.STARTS_WITH;
			}
		}

		this.orPredicate = orPredicate != null && orPredicate.equals(SearchOperation.OR_PREDICATE_FLAG);
		this.key = key;
		this.value = value;

	}
}
