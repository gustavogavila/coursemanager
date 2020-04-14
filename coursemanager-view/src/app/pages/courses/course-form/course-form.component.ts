import { Component, OnInit, Injector } from '@angular/core';
import { BaseResourceFormComponent } from 'src/app/shared/components/base-resource-form/base-resource-form.component';
import { Course } from '../shared/course.model';
import { CourseService } from '../shared/course.service';
import { Validators } from '@angular/forms';
import { TeacherService } from '../../teachers/shared/teacher.service';
import { Teacher } from '../../teachers/shared/teacher.model';

@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.css'],
})
export class CourseFormComponent extends BaseResourceFormComponent<Course> implements OnInit {

  teachers: Teacher[] = [];

  constructor(
    protected injector: Injector,
    protected courseService: CourseService,
    private teacherService: TeacherService,
    ) {
      super(injector, new Course(), courseService, Course.fromJson);
    }

  ngOnInit() {
    super.ngOnInit();
    this.teacherService.findAll().subscribe(
      data => this.teachers = data,
      error => console.log(error),
    );
  }

  protected buildResourceForm(): void {
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
      description: [
        null,
        [
          Validators.required,
          Validators.minLength(5),
          Validators.maxLength(200),
        ]
      ],
      price: [
        null,
        [
          Validators.required,
        ]
      ],
      teacher: [
        null,
        [
          Validators.required,
        ]
      ],
    });
  }

  protected creationPageTitle = (): string => 'Cadastro de Novo Curso';

  protected editionPageTitle = (): string =>
    this.resource?.name ? `Editando Curso: ${this.resource?.name}` : '';
}
