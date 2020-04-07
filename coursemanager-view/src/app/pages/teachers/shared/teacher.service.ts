import { Injectable, Injector } from '@angular/core';
import { BaseResourceService } from 'src/app/shared/services/base-resource.service';
import { Teacher } from './teacher.model';

@Injectable({
  providedIn: 'root',
})
export class TeacherService extends BaseResourceService<Teacher> {

  constructor(protected injector: Injector) {
    super('teachers', injector, Teacher.fromJson);
  }
}
