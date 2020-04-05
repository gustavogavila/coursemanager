package coursemanagerapi.models.enums;

public enum PaymentStatus {
	PAID("Paid"), PENDING("Pending");

	private String description;

	private PaymentStatus(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
