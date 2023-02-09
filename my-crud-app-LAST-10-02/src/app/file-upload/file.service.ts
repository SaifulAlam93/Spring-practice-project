import { HttpClient, HttpEvent, HttpHeaders, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FileService {

  private apiURL = "http://localhost:8080/api";



  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  
  constructor(private httpClient: HttpClient) { }

  upload(file: File, id:number): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();

    formData.append('file', file);

    const req = new HttpRequest('POST', `${this.apiURL}/upload?id=`+id, formData, {
      reportProgress: true,
      responseType: 'json'
    });

    return this.httpClient.request(req);
  }

  getFiles(): Observable<any> {
    return this.httpClient.get(`${this.apiURL}/files`);
  }
}
