import { OnInit } from '@angular/core';
import { BaseResourceModel } from '../models/base-resource.model';
import { BaseResourceService } from '../services/base-resource.service';

export abstract class BaseResourceListComponent<T extends BaseResourceModel>
  implements OnInit {

  resources: T[] = [];

  constructor(protected resourceService: BaseResourceService<T>) {}

  ngOnInit(): void {
    this.resourceService.findAll().subscribe(
      (resources) => (this.resources = resources),
      () => alert('Erro ao carregar a lista')
    );
  }

  deleteResource = (id: number) => {
    const confirmDelete = confirm('Deseja realmente excluir este item?');

    if (confirmDelete) {
      this.resourceService.deleteById(id).subscribe(
        () => (this.resources = this.resources.filter((t) => t.id != id)),
        () => alert('Erro ao remover registro')
      );
    }
  }
}
