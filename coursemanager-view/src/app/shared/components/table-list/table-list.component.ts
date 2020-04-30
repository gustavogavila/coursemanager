import { Component, EventEmitter, Input, OnInit, Output, TemplateRef } from '@angular/core';
import { BsModalService } from 'ngx-bootstrap/modal';
interface CustomField {
  label: string;
  value: any;
}

interface ModalAction {
  name: string;
  type: string;
  modalRef: TemplateRef<any>;
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

  @Output() deleteEvent = new EventEmitter();

  @Input() modalActions: ModalAction[];

  constructor(private modalService: BsModalService) {}

  ngOnInit(): void {}

  deleteResource(id: number): void {
    this.deleteEvent.emit(id);
  }

  openModal(modalRef: TemplateRef<any>) {
    this.modalService.show(modalRef);
  }
}
