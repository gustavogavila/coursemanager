import { Component, Injector } from '@angular/core';
import { Validators } from '@angular/forms';
import { BaseResourceFormComponent } from 'src/app/shared/components/base-resource-form.component';
import { Teacher } from '../shared/teacher.model';
import { TeacherService } from '../shared/teacher.service';

@Component({
  selector: 'app-teacher-form',
  templateUrl: './teacher-form.component.html',
  styleUrls: ['./teacher-form.component.css'],
})
export class TeacherFormComponent extends BaseResourceFormComponent<Teacher> {
  constructor(
    protected injector: Injector,
    protected teacherService: TeacherService
  ) {
    super(injector, new Teacher(), teacherService, Teacher.fromJson);
  }

  protected buildResourceForm = (): void => {
    this.resourceForm = this.formBuilder.group({
      id: [null],
      name: [
        null,
        [
          Validators.required,
          Validators.minLength(5),
          Validators.maxLength(200),
        ],
      ],
      email: [null, [Validators.required, Validators.email]],
      phone: [null],
    });
  };

  protected creationPageTitle = (): string => 'Cadastro de Novo Professor';

  protected editionPageTitle = (): string =>
    this.resource?.name ? `Editando Professor: ${this.resource?.name}` : '';
}
