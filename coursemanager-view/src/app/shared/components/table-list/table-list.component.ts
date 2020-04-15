import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

interface CustomField {
  label: string;
  value: any;
}

interface ModalAction {
  btnTitle: string;
  target: string;
}

@Component({
  selector: 'app-table-list',
  templateUrl: './table-list.component.html',
  styleUrls: ['./table-list.component.css'],
})
export class TableListComponent implements OnInit {
  @Input() title: string;
  @Input() resources: any[];
  @Input() mainField: CustomField;
  @Input() otherFields: CustomField[];
  @Input() modalActions: ModalAction[];

  @Output() deleteEvent = new EventEmitter();

  constructor() {}

  ngOnInit(): void {}

  deleteResource(id: number): void {
    this.deleteEvent.emit(id);
  }

  haveModalAction(): boolean {
    return this.modalActions && this.modalActions.length > 0;
  }
}
