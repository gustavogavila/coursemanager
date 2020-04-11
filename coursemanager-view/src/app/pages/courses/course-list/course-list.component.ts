import { Component, OnInit, Injector } from '@angular/core';
import { BaseResourceListComponent } from 'src/app/shared/components/base-resource-list/base-resource-list.component';
import { Course } from '../shared/course.model';
import { CourseService } from '../shared/course.service';

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css']
})
export class CourseListComponent extends BaseResourceListComponent<Course> {

  constructor(protected courseService: CourseService) {
    super(courseService);
  }
}
