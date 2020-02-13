import {ChangeDetectionStrategy, Component, Input, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {ActivatedRoute, Router} from '@angular/router';
import {DatePipe} from '@angular/common';


interface dataRecord {
  id: number;
  name: string;
  year: number;
}

@Component({
  templateUrl: 'add.component.html',
  changeDetection: ChangeDetectionStrategy.Default,
  providers: [DatePipe]
})
export class CityAddComponent implements OnInit {

  @Input('ngModel')
  account: dataRecord = {
    id: 0,
    name: '',
    year: 0
  };

  id: number = 0;
  name: string = '';
  year: number = 0;

  constructor(private router: Router, private route: ActivatedRoute, private http: HttpClient) {
  }

  ngOnInit(): void {
  }

  save(): void {

    this.account.name = this.name;
    this.account.year = this.year;


    console.log(this.account);

    this.http.post<any>
    (environment.apiUrl + '/bank/city/add', this.account)
      .subscribe(e => console.log(e),
        error => console.log(error));
    this.router.navigate(['city']);

  }

  back(): void {
    this.router.navigate(['city']);
  }

}
