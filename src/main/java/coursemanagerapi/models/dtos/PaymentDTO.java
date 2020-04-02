package coursemanagerapi.models.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class PaymentDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String studentName;
	private String courseName;
	private Integer month;
	private Integer year;
	private LocalDateTime expirationDate;
	private LocalDateTime payDate;
//	private BigDecimal paymentValue;
	private BigDecimal amountPaid;
	private String paymentStatus;
	

}
