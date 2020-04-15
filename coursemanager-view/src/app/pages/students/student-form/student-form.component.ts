import { Component, Injector } from '@angular/core';
import { BaseResourceFormComponent } from 'src/app/shared/components/base-resource-form/base-resource-form.component';
import { Student } from '../shared/student.model';
import { StudentService } from '../shared/student.service';
import { Validators } from '@angular/forms';

@Component({
  selector: 'app-student-form',
  templateUrl: './student-form.component.html',
  styleUrls: ['./student-form.component.css']
})
export class StudentFormComponent extends BaseResourceFormComponent<Student> {
  constructor(
    protected injector: Injector,
    protected studentService: StudentService,
  ) {
    super(injector, new Student(), studentService, Student.fromJson);
  }

  protected buildResourceForm(): void {
    this.resourceForm = this.formBuilder.group({
      id: [null],
      name: [
        null, [
          Validators.required,
          Validators.minLength(5),
          Validators.maxLength(200)
        ],
      ],
      email: [null, [Validators.email]],
      phone: [null],
    });
  }

  protected creationPageTitle = (): string => 'Cadastro de Novo Aluno';

  protected editionPageTitle = (): string =>
    this.resource?.name ? `Editando Aluno: ${this.resource.name}` : '';
}
