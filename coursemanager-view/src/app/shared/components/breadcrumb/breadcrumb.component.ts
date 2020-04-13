import { Component, OnInit, Input } from '@angular/core';

interface BreadcrumbItem {
  label: string;
  link?: string;
}

@Component({
  selector: 'app-breadcrumb',
  templateUrl: './breadcrumb.component.html',
  styleUrls: ['./breadcrumb.component.css'],
})
export class BreadcrumbComponent implements OnInit {
  @Input()
  items: BreadcrumbItem[] = [];

  constructor() {}

  ngOnInit(): void {}

  isTheLastItem(item: BreadcrumbItem): boolean {
    const index = this.items.indexOf(item);
    return index === this.items.length - 1;
  }
}
