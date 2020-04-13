import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { BreadcrumbComponent } from './components/breadcrumb/breadcrumb.component';
import { PageTitleComponent } from './components/page-title/page-title.component';
import { FormFieldErrorComponent } from './components/form-field-error/form-field-error.component';
import { ServerErrorMessagesComponent } from './components/server-error-messages/server-error-messages.component';
import { TableListComponent } from './components/table-list/table-list.component';

@NgModule({
  declarations: [
    BreadcrumbComponent,
    PageTitleComponent,
    FormFieldErrorComponent,
    ServerErrorMessagesComponent,
    TableListComponent,
  ],
  imports: [CommonModule, ReactiveFormsModule, RouterModule],
  exports: [
    // shared modules
    CommonModule,
    ReactiveFormsModule,
    RouterModule,

    // shared components
    BreadcrumbComponent,
    PageTitleComponent,
    FormFieldErrorComponent,
    ServerErrorMessagesComponent,
    TableListComponent,
  ],
})
export class SharedModule {}
