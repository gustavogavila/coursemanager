import { Component } from '@angular/core';
import { BaseResourceListComponent } from 'src/app/shared/components/base-resource-list/base-resource-list.component';
import { Teacher } from '../shared/teacher.model';
import { TeacherService } from '../shared/teacher.service';

@Component({
  selector: 'app-teacher-list',
  templateUrl: './teacher-list.component.html',
  styleUrls: ['./teacher-list.component.css'],
})
export class TeacherListComponent extends BaseResourceListComponent<Teacher> {

  constructor(protected teacherService: TeacherService) {
    super(teacherService);
  }
}
