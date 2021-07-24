import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private apiURL = "http://localhost:8080/publications/3";
  list: any;

  constructor(private httpClient : HttpClient) { }

  getOffers(){
    this.httpClient.get(this.apiURL).subscribe(
      (response) => {
        this.list = response;
        console.log(response);
      },
      (error) => {

      }
    );
  }
}
