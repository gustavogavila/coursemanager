import { Component, OnInit, Input } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-form-field-error',
  template: `
    <div class="text-danger">
      {{ errorMessage }}
    </div>
  `,
  styleUrls: ['./form-field-error.component.css'],
})
export class FormFieldErrorComponent implements OnInit {
  @Input() formControl: FormControl;

  constructor() {}

  ngOnInit(): void {}

  public get errorMessage(): string | null {
    return this.mustShowErrorMessage() ? this.getErrorMessage() : null;
  }

  private mustShowErrorMessage(): boolean {
    return this.formControl.invalid && this.formControl.touched;
  }

  private getErrorMessage() {
    if (this.formControl.errors.required) {
      return 'dado obrigatório';
    }
    if (this.formControl.errors.email) {
      return 'e-mail inválido';
    }
    if (this.formControl.errors.minlength) {
      const requiredLength = this.formControl.errors.minlength.requiredLength;
      return `deve ter no mínimo ${requiredLength} caracteres`;
    }
    if (this.formControl.errors.maxlength) {
      const requiredLength = this.formControl.errors.maxlength.requiredLength;
      return `deve ter no máximo ${requiredLength} caracteres`;
    }
  }
}
