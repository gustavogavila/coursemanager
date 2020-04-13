import { HttpClient } from '@angular/common/http';
import { Injector } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { BaseResourceModel } from '../models/base-resource.model';

export abstract class BaseResourceService<T extends BaseResourceModel> {
  protected http: HttpClient;
  protected apiPath: string;

  constructor(
    protected endpoint: string,
    protected injector: Injector,
    protected jsonDataToResourceFn: (jsonData: any) => T,
  ) {
    this.http = injector.get(HttpClient);
    this.apiPath = `http://localhost:8080/${this.endpoint}`;
  }

  findAll = (): Observable<T[]> => {
    return this.http
      .get(this.apiPath)
      .pipe(map(this.jsonDataToResources), catchError(this.handleError));
  };

  findById = (id: number): Observable<T> => {
    const url = `${this.apiPath}/${id}`;
    return this.http
      .get(url)
      .pipe(map(this.jsonDataToResource), catchError(this.handleError));
  };

  save = (resource: T): Observable<T> => {
    return this.http
      .post(this.apiPath, resource)
      .pipe(map(this.jsonDataToResource), catchError(this.handleError));
  };

  update = (resource: T): Observable<T> => {
    const url = `${this.apiPath}/${resource.id}`;
    return this.http
      .put(url, resource)
      .pipe(map(this.jsonDataToResource), catchError(this.handleError));
  };

  deleteById = (id: number): Observable<any> => {
    const url = `${this.apiPath}/${id}`;
    return this.http.delete(url).pipe(
      map(() => null),
      catchError(this.handleError),
    );
  };

  protected jsonDataToResources = (jsonData: any): T[] =>
    jsonData.map((element: any) => this.jsonDataToResourceFn(element));

  protected jsonDataToResource = (jsonData: any): T =>
    this.jsonDataToResourceFn(jsonData);

  protected handleError = (error: any): Observable<any> => {
    console.log('Erro na requisição: ', error);
    return throwError(error);
  };
}
