import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";

import { Observable, throwError } from "rxjs";
import { map, catchError, flatMap } from "rxjs/operators";
import { Teacher } from './teacher.model';

@Injectable({
  providedIn: 'root'
})
export class TeacherService {

  private apiPath: string = "http://localhost:8080/teachers"

  constructor(private http: HttpClient) { }

  findAll(): Observable<Teacher[]> {
    return this.http.get(this.apiPath).pipe(
      map(this.jsonDataToTeachers),
      catchError(this.handleError)
    )
  }

  findById(id: number): Observable<Teacher> {
    const url = `${this.apiPath}/${id}`;
    return this.http.get(url).pipe(
      map(this.jsonDataToTeacher),
      catchError(this.handleError)
    )
  }

  save(teacher: Teacher): Observable<Teacher> {
    return this.http.post(this.apiPath, teacher).pipe(
      map(this.jsonDataToTeacher),
      catchError(this.handleError)
    )
  }

  update(teacher: Teacher): Observable<Teacher> {
    const url = `${this.apiPath}/${teacher.id}`;
    return this.http.put(url, teacher).pipe(
      map(this.jsonDataToTeacher),
      catchError(this.handleError)
    )
  }

  deleteById(id: number): Observable<any> {
    const url = `${this.apiPath}/${id}`;
    return this.http.delete(url).pipe(
      map(() => null),
      catchError(this.handleError)
    )
  }

  private jsonDataToTeachers(jsonData: any[]): Teacher[] {
    return jsonData.map(element => Object.assign(new Teacher(), element))
  }

  private jsonDataToTeacher(jsonData: any): Teacher {
    return Object.assign(new Teacher(), jsonData);
  }

  private handleError(error: any): Observable<any> {
    console.log("Erro na requisição: ", error);
    return throwError(error);
  }
}
