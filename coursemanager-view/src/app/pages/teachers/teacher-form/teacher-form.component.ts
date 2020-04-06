import { AfterContentChecked, Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

import { switchMap } from 'rxjs/operators';
import { Teacher } from '../shared/teacher.model';
import { TeacherService } from '../shared/teacher.service';

import toastr from 'toastr';

@Component({
  selector: 'app-teacher-form',
  templateUrl: './teacher-form.component.html',
  styleUrls: ['./teacher-form.component.css'],
})
export class TeacherFormComponent implements OnInit, AfterContentChecked {
  currentAction: string;
  teacherForm: FormGroup;
  pageTitle: string;
  serverErrorMessages: string[];
  submittingForm: boolean = false;
  teacher: Teacher = new Teacher();

  constructor(
    private teacherService: TeacherService,
    private route: ActivatedRoute,
    private router: Router,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.setCurrentAction();
    this.buildTeacherForm();
    this.loadTeacher();
  }

  ngAfterContentChecked(): void {
    this.setPageTitle();
  }


  submitForm() {
    this.submittingForm = true;
    if (this.currentAction = 'new') {
      this.saveTeacher();
    } else {
      this.updateTeacher();
    }
  }


  // Private Methods

  private saveTeacher() {
    const teacher = Object.assign(new Teacher(), this.teacherForm.value);

    this.teacherService.save(teacher).subscribe(
      teacher => this.actionsForSuccess(teacher),
      error => this.actionsForError(error)
    );
  }

  private updateTeacher() {
    this.teacherService.update(this.teacherForm.value);
  }

  private actionsForSuccess(teacher: Teacher): void {
    toastr.success('Dados salvos com sucesso!');
    this.router.navigateByUrl('teachers', { skipLocationChange: true })
      .then(() => this.router.navigate(['teachers', teacher.id, 'edit']))
  }

  private actionsForError(error: any): void {
    toastr.error('Ocorreu um erro ao processar sua solicitação.');

    this.submittingForm = false;

    if (error.status === 422) {
      this.serverErrorMessages = JSON.parse(error._body).errors;
    } else {
      this.serverErrorMessages = ['Falha na comunicação com o servidor. Tente novamente mais tarde.'];
    }
  }

  private setCurrentAction(): void {
    this.currentAction =
      this.route.snapshot.url[0].path === 'new' ? 'new' : 'edit';
  }

  private buildTeacherForm() {
    this.teacherForm = this.formBuilder.group({
      id: [null],
      name: [
        null,
        Validators.required,
        Validators.minLength(5),
        Validators.maxLength(200),
      ],
      email: [null, Validators.required, Validators.email],
      phone: [null],
    });
  }

  private loadTeacher(): void {
    if (this.currentAction === 'edit') {
      this.route.paramMap
        .pipe(
          switchMap((params) => this.teacherService.findById(+params.get('id')))
        )
        .subscribe(
          (teacher) => {
            this.teacher = teacher;
            this.teacherForm.patchValue(teacher);
            console.log(this.teacherForm)
          },
          () => alert('Ocorreu um erro no servidor, tente mais tarde.')
        );
    }
  }

  private setPageTitle() {
    const teacherName = this.teacher?.name || '';
    this.pageTitle =
      this.currentAction === 'new'
        ? 'Cadastro de Novo Professor'
        : `Editando professor ${teacherName}`;
  }
}
