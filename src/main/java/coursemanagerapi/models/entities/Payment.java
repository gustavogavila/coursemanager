package coursemanagerapi.models.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import coursemanagerapi.models.enums.PaymentStatus;
import coursemanagerapi.models.enums.PaymentStatusConverter;
import coursemanagerapi.models.enums.YearConverter;
import lombok.Data;

@Entity
@Table(name = "payment")
@Data
public class Payment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(nullable = false, columnDefinition = "smallint")
	private Month month;

	@Convert(converter = YearConverter.class)
	@Column(nullable = false)
	private Year year;

	@Convert(converter = PaymentStatusConverter.class)
	@Column(name = "payment_status", nullable = false)
	private PaymentStatus paymentStatus;

	@Column(name = "amount_paid", nullable = false)
	private BigDecimal amountPaid;

	@Column(name = "pay_date", nullable = false)
	private LocalDateTime payDate;

	@Column(name = "expiration_date", nullable = false)
	private LocalDateTime expirationDate;

	@ManyToOne
	@JoinColumn(name = "enrollment_id", nullable = false)
	private Enrollment enrollment;
}
