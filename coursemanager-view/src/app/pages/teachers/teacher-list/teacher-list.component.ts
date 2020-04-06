import { Component, OnInit } from '@angular/core';

import { TeacherService } from '../shared/teacher.service';
import { Teacher } from '../shared/teacher.model';

@Component({
  selector: 'app-teacher-list',
  templateUrl: './teacher-list.component.html',
  styleUrls: ['./teacher-list.component.css']
})
export class TeacherListComponent implements OnInit {

  teachers: Teacher[] = [];

  constructor(private teacherService: TeacherService) { }

  ngOnInit(): void {
    this.teacherService.findAll().subscribe(
      teachers => this.teachers = teachers,
      () => alert('Erro ao carregar a lista'),
    );
  }

  deleteTeacher(id: number) {
    const confirmDelete = confirm('Deseja realmente excluir este item?');

    if (confirmDelete) {
      this.teacherService.deleteById(id).subscribe(
        () => this.teachers = this.teachers.filter(t => t.id != id),
        () => alert('Erro ao remover registro'),
        );
    }
  }


}
