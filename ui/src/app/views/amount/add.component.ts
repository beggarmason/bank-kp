import {ChangeDetectionStrategy, Component, Input, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {ActivatedRoute, Router} from '@angular/router';
import {DatePipe} from '@angular/common';


interface dataRecord {
  id: number;
  active: boolean;
  balance: number;
  debt: number;
  name: string;
  account: any;
  deposit: any;
  accountId: number
  depositId: number
}

@Component({
  templateUrl: 'add.component.html',
  changeDetection: ChangeDetectionStrategy.Default,
  providers: [DatePipe]
})
export class AmountAddComponent implements OnInit {

  @Input('ngModel')
  amount: dataRecord = {
    id: 0,
    active: false,
    name: '',
    debt: 0,
    balance: 0,
    account: null,
    deposit: null,
    accountId: 1,
    depositId: 1
  };

  active: boolean = false;
  name: string = '';
  debt: number = 0;
  balance: number = 0;
  accountId: number = 1;
  depositId: number = 1;

  constructor(private router: Router, private route: ActivatedRoute, private http: HttpClient) {
  }

  ngOnInit(): void {
  }

  save(): void {

    this.amount.active = this.active;
    this.amount.debt = this.debt;
    this.amount.balance = this.balance;
    this.amount.accountId = this.accountId;
    this.amount.depositId = this.depositId;
    this.amount.name = this.name;

    console.log(this.amount);

    this.http.post<any>
    (environment.apiUrl + '/bank/amount/add', this.amount)
      .subscribe(e => console.log(e),
        error => console.log(error));
    this.router.navigate(['amount']);

  }

  back(): void {
    this.router.navigate(['amount']);
  }

}
