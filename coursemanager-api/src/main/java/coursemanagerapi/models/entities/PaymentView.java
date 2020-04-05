package coursemanagerapi.models.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="payment_view")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class PaymentView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	
	@Column(name = "payment_id")
	private Long paymentId;
	
	@Column(name = "student_name")
	private String studentName;
	
	@Column(name = "course_name")
	private String courseName;
	
	private Integer month;
	private Integer year;
	
	@Column(name = "expiration_date")
	private LocalDateTime expirationDate;
	
	@Column(name = "pay_date")
	private LocalDateTime payDate;
	
	@Column(name = "payment_value")
	private BigDecimal paymentValue;
	
	@Column(name = "amount_paid")
	private BigDecimal amountPaid;
	
	@Column(name = "payment_status")
	private String paymentStatus;
	

}
