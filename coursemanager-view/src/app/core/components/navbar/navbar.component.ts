import { Component, OnInit, Input } from '@angular/core';

interface MenuItem {
  label: string;
  link: string;
}

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  @Input() menus: MenuItem[] = [];
  @Input() pageTitle: string;

  constructor() {}

  ngOnInit(): void {}
}
