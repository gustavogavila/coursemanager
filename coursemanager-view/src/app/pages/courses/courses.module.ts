import { NgModule } from '@angular/core';

import { CoursesRoutingModule } from './courses-routing.module';
import { CourseListComponent } from './course-list/course-list.component';
import { CourseFormComponent } from './course-form/course-form.component';
import { SharedModule } from 'src/app/shared/shared.module';


@NgModule({
  declarations: [CourseListComponent, CourseFormComponent],
  imports: [
    SharedModule,
    CoursesRoutingModule
  ]
})
export class CoursesModule { }
