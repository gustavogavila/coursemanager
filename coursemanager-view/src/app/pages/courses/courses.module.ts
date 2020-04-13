import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { CoursesRoutingModule } from './courses-routing.module';
import { CourseListComponent } from './course-list/course-list.component';
import { CourseFormComponent } from './course-form/course-form.component';
import { SharedModule } from 'src/app/shared/shared.module';

@NgModule({
  declarations: [CourseListComponent, CourseFormComponent],
  imports: [SharedModule, CoursesRoutingModule],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class CoursesModule {}
