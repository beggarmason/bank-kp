import {ChangeDetectionStrategy, Component, Input, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {ActivatedRoute, Router} from '@angular/router';
import {DatePipe} from '@angular/common';


interface dataRecord {
    id: number;
    active: boolean;
    currency: string;
    fromDate: Date;
    name: string;
    toDate: Date;
    year: number;
    bonus: any;
    person: any;
    plan: any;
    type: any;
    bonusid: number;
    personid: number;
    planid: number;
    typeid: number;
}

@Component({
  templateUrl: 'add.component.html',
  changeDetection: ChangeDetectionStrategy.Default,
  providers: [DatePipe]
})
export class DepositAddComponent implements OnInit {

    @Input('ngModel')
    account: dataRecord = {
        id: 0,
        active: false,
        currency: '',
        fromDate: new Date(),
        name:  '',
        toDate: new Date(),
        year:  0,
        bonus: null,
        person: null,
        plan:  null,
        type: null,
        bonusid: 0,
        personid: 0,
        planid: 0,
        typeid: 0
    };

    id: number = 0;
    active: boolean = false;
    currency: string = '';
    fromDate: Date = new Date();
    name: string = '';
    toDate: Date = new Date();
    year: number = 0;
    bonus: any = null;
    person: any = null;
    plan: any = null;
    type: any = null;
    bonusid: number = 0;
    personid: number = 0;
    planid: number = 0;
    typeid: number = 0;

  constructor(private router: Router, private route: ActivatedRoute, private http: HttpClient) {
  }

  ngOnInit(): void {
  }

  save(): void {

        this.account.currency = this.currency;
        this.account.fromDate = this.fromDate;
        this.account.name = this.name;
        this.account.toDate = this.toDate;
        this.account.year = this.year;
        this.account.bonus = this.bonus;
        this.account.person = this.person;
        this.account.plan = this.plan;
        this.account.type = this.type;
        this.account.bonusid = this.bonusid;
        this.account.personid = this.personid;
        this.account.planid = this.planid;
        this.account.typeid = this.typeid;


    console.log(this.account);

    this.http.post<any>
    (environment.apiUrl + '/bank/deposit/add', this.account)
      .subscribe(e => console.log(e),
        error => console.log(error));
    this.router.navigate(['deposit']);

  }

  back(): void {
    this.router.navigate(['deposit']);
  }

}
