import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StudentsRoutingModule } from './students-routing.module';
import { StudentFormComponent } from './student-form/student-form.component';
import { StudentListComponent } from './student-list/student-list.component';
import { SharedModule } from 'src/app/shared/shared.module';


@NgModule({
  declarations: [StudentFormComponent, StudentListComponent],
  imports: [
    SharedModule,
    StudentsRoutingModule
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class StudentsModule { }
