import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ResponsePageable } from '../model/responsePageable.model';

@Injectable({ providedIn: 'root' })
export class Service {

    apiUrl = 'http://localhost:8080/api/dados/upload-xml';
    apiUrlGet = 'http://localhost:8080/api/dados/agentes'
    httpOptions = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json'
        })
      };

    constructor(
        private httpClient: HttpClient
    ) {}

    public getAgentes(): Observable<ResponsePageable> {
        return this.httpClient.get<ResponsePageable>(this.apiUrlGet);
    }

    public getAgentesWithFlag(flag: string): Observable<ResponsePageable> {
        return this.httpClient.get<ResponsePageable>(this.apiUrlGet + '?flag=' + flag);
    }

    public postAgentes(live: any): Observable<ResponsePageable> {
        return this.httpClient.post<any>(this.apiUrl, live, this.httpOptions);
    }

}