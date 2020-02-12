import {ChangeDetectionStrategy, Component, Input, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {ActivatedRoute, Router} from '@angular/router';
import {DatePipe} from '@angular/common';


interface dataRecord {
  id: number;
  active: boolean;
  number: string;
  created: Date;
  restriction: [];
  person: any;
  personId: number
}

@Component({
  templateUrl: 'add.component.html',
  changeDetection: ChangeDetectionStrategy.Default,
  providers: [DatePipe]
})
export class AddComponent implements OnInit {

  @Input('ngModel')
  account: dataRecord = {
    id: 0,
    active: false,
    number: '',
    created: new Date(),
    restriction: null,
    person: null,
    personId: 0
  };

  active: boolean = false;
  number: string = '';
  created: Date = new Date();
  person: number = 0;
  personId: number = 0;

  constructor(private router: Router, private route: ActivatedRoute, private http: HttpClient) {
  }

  ngOnInit(): void {
  }

  save(): void {

    this.account.active = this.active;
    this.account.created = this.created;
    this.account.number = this.number;
    this.account.personId = this.personId;

    console.log(this.account);

    this.http.post<any>
    (environment.apiUrl + '/bank/accounts/add', this.account)
      .subscribe(e => console.log(e),
        error => console.log(error));
    this.router.navigate(['account']);

  }

  back(): void {
    this.router.navigate(['account']);
  }

}
