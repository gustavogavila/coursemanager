import { AfterContentChecked, Injector, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

import { switchMap } from 'rxjs/operators';
import toastr from 'toastr';
import { BaseResourceModel } from '../../models/base-resource.model';
import { BaseResourceService } from '../../services/base-resource.service';

export abstract class BaseResourceFormComponent<T extends BaseResourceModel>
  implements OnInit, AfterContentChecked {
  currentAction: string;
  resourceForm: FormGroup;
  pageTitle: string;
  serverErrorMessages: string[] = null;
  submittingForm = false;

  protected route: ActivatedRoute;
  protected router: Router;
  protected formBuilder: FormBuilder;

  constructor(
    protected injector: Injector,
    protected resource: T,
    protected resourceService: BaseResourceService<T>,
    protected jsonDataToResourceFn: (jsonData: any) => T,
  ) {
    this.route = this.injector.get(ActivatedRoute);
    this.router = this.injector.get(Router);
    this.formBuilder = this.injector.get(FormBuilder);
  }

  ngOnInit(): void {
    this.setCurrentAction();
    this.buildResourceForm();
    this.loadResource();
  }

  ngAfterContentChecked(): void {
    this.setPageTitle();
  }

  submitForm = (): void => {
    this.submittingForm = true;
    if (this.currentAction === 'new') {
      this.saveResource();
    } else {
      this.updateResource();
    }
  };

  // Protected Methods

  protected setCurrentAction = (): void => {
    this.currentAction =
      this.route.snapshot.url[0].path === 'new' ? 'new' : 'edit';
  };

  protected abstract buildResourceForm(): void;

  protected loadResource = (): void => {
    if (this.currentAction === 'edit') {
      this.route.paramMap
        .pipe(
          switchMap(params => this.resourceService.findById(+params.get('id'))),
        )
        .subscribe(
          resource => {
            this.resource = resource;
            this.resourceForm.patchValue(resource);
          },
          () => alert('Ocorreu um erro no servidor, tente mais tarde.'),
        );
    }
  };

  protected setPageTitle = (): void => {
    this.pageTitle =
      this.currentAction === 'new'
        ? this.creationPageTitle()
        : this.editionPageTitle();
  };

  protected creationPageTitle = (): string => 'Novo';

  protected editionPageTitle = (): string => 'Edição';

  protected saveResource = (): void => {
    const resource: T = this.jsonDataToResourceFn(this.resourceForm.value);

    this.resourceService.save(resource).subscribe(
      r => this.actionsForSuccess(r),
      error => this.actionsForError(error),
    );
  };

  protected updateResource = (): void => {
    const resource: T = this.jsonDataToResourceFn(this.resourceForm.value);

    this.resourceService.update(resource).subscribe(
      r => this.actionsForSuccess(r),
      error => this.actionsForError(error),
    );
  };

  protected actionsForSuccess = (resource: T): void => {
    toastr.success('Dados salvos com sucesso!');

    const baseComponentPath: string = this.route.snapshot.parent.url[0].path;

    this.router
      .navigateByUrl(baseComponentPath, { skipLocationChange: true })
      .then(() =>
        this.router.navigate([baseComponentPath, resource.id, 'edit']),
      );
  };

  protected actionsForError = (error: any): void => {
    toastr.error('Ocorreu um erro ao processar sua solicitação.');

    this.submittingForm = false;

    if (error.status === 422) {
      this.serverErrorMessages = JSON.parse(error._body).errors;
    } else {
      this.serverErrorMessages = [
        'Falha na comunicação com o servidor. Tente novamente mais tarde.',
      ];
    }
  };
}
