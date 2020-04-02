package coursemanagerapi.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Entity
@Table(name = "course")
@Data
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 5, max = 200, message = "O tamanho deve ser entre 5 e 200 caracteres")
	@Column(name = "name", nullable = false)
	private String name;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 5, max = 200, message = "O tamanho deve ser entre 5 e 200 caracteres")
	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "teacher_id", referencedColumnName = "id", nullable = false)
	private Teacher teacher;
}
