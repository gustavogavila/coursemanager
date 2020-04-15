import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: 'teachers',
    loadChildren: () =>
      import('./pages/teachers/teachers.module').then(m => m.TeachersModule),
  },
  {
    path: 'courses',
    loadChildren: () =>
      import('./pages/courses/courses.module').then(m => m.CoursesModule),
  },
  {
    path: 'students',
    loadChildren: () =>
      import('./pages/students/students.module').then(m => m.StudentsModule),
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
