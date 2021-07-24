import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  appareils: any;

  constructor(private apiService : ApiService) { }

  ngOnInit(): void {
    this.apiService.getOffers();
    this.appareils = this.apiService.list;
    console.log(this.appareils);
  }

}
