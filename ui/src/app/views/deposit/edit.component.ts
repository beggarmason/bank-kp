import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {ActivatedRoute, Router} from '@angular/router';
import { DatePipe } from '@angular/common';

interface dataRecord {
  id: number;
  active: boolean;
  currency: string;
  fromDate: string;
  name: string;
  toDate: string;
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
  templateUrl: 'edit.component.html',
  changeDetection: ChangeDetectionStrategy.Default,
  providers: [DatePipe]
})
export class DepositEditComponent implements OnInit {

  account: dataRecord;
  originalId: number;

  constructor(private router: Router, private route: ActivatedRoute, private http: HttpClient, private datePipe: DatePipe) {
  }

  ngOnInit(): void {
    this.http.get<any>(environment.apiUrl + '/bank/deposit/' + this.route.snapshot.params.id).subscribe(data => {
      this.account = data;
      this.originalId = data.id;
      let fd = this.account.fromDate.toString();
      let td = this.account.toDate.toString();

      let s1 = fd.substr(0, 10);
      let s2 = td.substr(0, 10);
      this.account.fromDate = s1;
      this.account.toDate = s2;
    })
  }

  save(): void {
    console.log(this.account);
    this.http.post<any>
    (environment.apiUrl + '/bank/deposit/edit/'+this.originalId, this.account)
      .subscribe(e => console.log(e),
          error => console.log(error));
    this.router.navigate(['deposit']);
  }

  back(): void {
    this.router.navigate(['deposit']);
  }

}
