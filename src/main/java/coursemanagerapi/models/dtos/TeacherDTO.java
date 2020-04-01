package coursemanagerapi.models.dtos;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import coursemanagerapi.models.entities.Teacher;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TeacherDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 5, max = 200, message = "O tamanho deve ser entre 5 e 200 caracteres")
	private String name;
	
	@Email(message = "E-mail inválido")
	private String email;
	
	private String phone;

	public TeacherDTO(Teacher teacher) {
		id = teacher.getId();
		name = teacher.getName();
		email = teacher.getEmail();
		phone = teacher.getPhone();
	}

}
