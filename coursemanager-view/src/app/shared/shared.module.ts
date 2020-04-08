import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { BreadcrumbComponent } from './components/breadcrumb/breadcrumb.component';

@NgModule({
  declarations: [BreadcrumbComponent],
  imports: [CommonModule, ReactiveFormsModule, RouterModule],
  exports: [
    // shared modules
    CommonModule,
    ReactiveFormsModule,
    RouterModule,

    // shared components
    BreadcrumbComponent,
  ],
})
export class SharedModule {}
