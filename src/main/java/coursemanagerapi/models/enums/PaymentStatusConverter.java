package coursemanagerapi.models.enums;

import java.util.ArrayList;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class PaymentStatusConverter implements AttributeConverter<PaymentStatus, String> {

	@Override
	public String convertToDatabaseColumn(PaymentStatus attribute) {
		if (attribute == null)
			return null;
		return attribute.getDescription();
	}

	@Override
	public PaymentStatus convertToEntityAttribute(String dbData) {
		if (dbData == null)
			return null;

		ArrayList<PaymentStatus> list = new ArrayList<>();
		for (PaymentStatus status : PaymentStatus.values()) {
			list.add(status);
		}

		return list.stream().filter(s -> s.getDescription().equals(dbData)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
