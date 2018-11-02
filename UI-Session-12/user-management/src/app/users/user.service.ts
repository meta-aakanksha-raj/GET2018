import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import { User } from './user';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private usersUrl:string = "http://localhost:3000/users";

  constructor( private http: HttpClient) { }

   /** GET users from the server */
   getUsers (): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl);
  }

    /** GET hero by id. Will 404 if id not found */
    getUser(id: number): Observable<User> {
      const url = `${this.usersUrl}/${id}`;
      return this.http.get<User>(url);
  }

  /** POST: add a new user to the server */
  addUser (user: User): Observable<User> {
    console.log("Post the user service called." + user.name + " : id "+user.id);
    return this.http.post<User>(this.usersUrl, user, httpOptions);
  }

   /** PUT: update the hero on the server */
   updateUser (user: User): Observable<any> {
    return this.http.put(`${this.usersUrl}/${user.id}`, user, httpOptions);
  }
}
