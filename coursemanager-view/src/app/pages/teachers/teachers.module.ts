import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { TeachersRoutingModule } from './teachers-routing.module';
import { TeacherListComponent } from './teacher-list/teacher-list.component';
import { TeacherFormComponent } from './teacher-form/teacher-form.component';


@NgModule({
  declarations: [TeacherListComponent, TeacherFormComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    TeachersRoutingModule
  ]
})
export class TeachersModule { }
