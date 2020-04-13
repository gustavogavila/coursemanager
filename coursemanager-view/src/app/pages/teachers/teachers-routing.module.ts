import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { TeacherListComponent } from './teacher-list/teacher-list.component';
import { TeacherFormComponent } from './teacher-form/teacher-form.component';

const routes: Routes = [
  { path: '', component: TeacherListComponent },
  { path: 'new', component: TeacherFormComponent },
  { path: ':id/edit', component: TeacherFormComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class TeachersRoutingModule {}
