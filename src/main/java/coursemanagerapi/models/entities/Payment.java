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

import coursemanagerapi.models.enums.MonthConverter;
import coursemanagerapi.models.enums.PaymentStatus;
import coursemanagerapi.models.enums.PaymentStatusConverter;
import coursemanagerapi.models.enums.YearConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Convert(converter = MonthConverter.class)
	private Month month;

	@Convert(converter = YearConverter.class)
	private Year year;

	@Convert(converter = PaymentStatusConverter.class)
	@Column(name = "payment_status")
	private PaymentStatus paymentStatus = PaymentStatus.PENDING;

	@Column(name = "amount_paid")
	private BigDecimal amountPaid;

	@Column(name = "pay_date")
	private LocalDateTime payDate;

	@Column(name = "expiration_date")
	private LocalDateTime expirationDate;

	@ManyToOne
	@JoinColumn(name = "enrollment_id", nullable = false)
	private Enrollment enrollment;
}
