import { Injectable, Injector } from '@angular/core';
import { BaseResourceService } from 'src/app/shared/services/base-resource.service';
import { Course } from './course.model';

@Injectable({
  providedIn: 'root'
})
export class CourseService extends BaseResourceService<Course> {

  constructor(protected injector: Injector) {
    super('courses', injector, Course.fromJson);
  }
}
