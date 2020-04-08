import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { BreadcrumbComponent } from './components/breadcrumb/breadcrumb.component';
import { PageTitleComponent } from './components/page-title/page-title.component';

@NgModule({
  declarations: [BreadcrumbComponent, PageTitleComponent],
  imports: [CommonModule, ReactiveFormsModule, RouterModule],
  exports: [
    // shared modules
    CommonModule,
    ReactiveFormsModule,
    RouterModule,

    // shared components
    BreadcrumbComponent,
    PageTitleComponent
  ],
})
export class SharedModule {}
