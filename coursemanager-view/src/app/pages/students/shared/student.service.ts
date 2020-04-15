import { Injectable, Injector } from '@angular/core';
import { BaseResourceService } from 'src/app/shared/services/base-resource.service';
import { Student } from './student.model';

@Injectable({
  providedIn: 'root'
})
export class StudentService extends BaseResourceService<Student> {
  constructor(protected injector: Injector) {
    super('students', injector, Student.fromJson);
  }
}
