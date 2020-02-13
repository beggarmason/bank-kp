import {ChangeDetectionStrategy, Component, Input, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {ActivatedRoute, Router} from '@angular/router';
import {DatePipe} from '@angular/common';


interface dataRecord {
  id: number;
  active: boolean;
  name: string;
  created: Date;
}

@Component({
  templateUrl: 'add.component.html',
  changeDetection: ChangeDetectionStrategy.Default,
  providers: [DatePipe]
})
export class BankAddComponent implements OnInit {

  @Input('ngModel')
  bank: dataRecord = {
    id: 0,
    active: false,
    name: '',
    created: new Date()
  };

  active: boolean = false;
  name: string = '';
  created: Date = new Date();

  constructor(private router: Router, private route: ActivatedRoute, private http: HttpClient) {
  }

  ngOnInit(): void {
  }

  save(): void {

    this.bank.active = this.active;
    this.bank.created = this.created;
    this.bank.name = this.name;

    console.log(this.bank);

    this.http.post<any>
    (environment.apiUrl + '/bank/bank/add', this.bank)
      .subscribe(e => console.log(e),
        error => console.log(error));
    this.router.navigate(['bank']);

  }

  back(): void {
    this.router.navigate(['bank']);
  }

}
