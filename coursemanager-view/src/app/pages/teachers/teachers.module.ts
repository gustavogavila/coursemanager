import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { SharedModule } from 'src/app/shared/shared.module';
import { TeacherFormComponent } from './teacher-form/teacher-form.component';
import { TeacherListComponent } from './teacher-list/teacher-list.component';
import { TeachersRoutingModule } from './teachers-routing.module';

@NgModule({
  declarations: [TeacherListComponent, TeacherFormComponent],
  imports: [SharedModule, TeachersRoutingModule],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class TeachersModule {}
