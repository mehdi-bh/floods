import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private apiURL = "https://reqres.in/api/users?page=2";
  list: any[] = [];

  constructor(private httpClient : HttpClient) { }

  getOffers(){
    this.httpClient.get<any[]>(this.apiURL).subscribe(
      (response) => {
        this.list = response;
        console.log(response);
      },
      (error) => {

      }
    );
  }
}
