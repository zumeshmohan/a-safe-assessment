import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Joke} from './joke.model';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root',
  })

export class JokeService{
  private apiUrl = '/api/v1/jokes';

  constructor(private http: HttpClient){}

  getJoke(id: number):Observable<Joke>{
      return this.http.get<Joke>(`${this.apiUrl}/${id}`);
    }

  getJokeCount():Observable<number>{
      return this.http.get<number>(`${this.apiUrl}/count`);
    }

  }
