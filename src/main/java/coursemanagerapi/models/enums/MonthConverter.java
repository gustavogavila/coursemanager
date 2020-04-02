package coursemanagerapi.models.enums;

import java.time.Month;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class MonthConverter implements AttributeConverter<Month, Short> {

	@Override
	public Short convertToDatabaseColumn(Month month) {
		return (short) month.getValue();
	}

	@Override
	public Month convertToEntityAttribute(Short intMonth) {
		return Month.of(intMonth);
	}

}
