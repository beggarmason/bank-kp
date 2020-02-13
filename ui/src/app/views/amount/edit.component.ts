import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {ActivatedRoute, Router} from '@angular/router';
import { DatePipe } from '@angular/common';

interface dataRecord {
  id: number;
  active: boolean;
  balance: number;
  debt: number;
  name: string;
  created: string;
  account: any;
  deposit: any;
  accountId: number
  depositId: number
}

@Component({
  templateUrl: 'edit.component.html',
  changeDetection: ChangeDetectionStrategy.Default,
  providers: [DatePipe]
})
export class AmountEditComponent implements OnInit {

  amount: dataRecord;
  originalId: number;

  constructor(private router: Router, private route: ActivatedRoute, private http: HttpClient, private datePipe: DatePipe) {
  }

  ngOnInit(): void {
    this.http.get<any>(environment.apiUrl + '/bank/amount/' + this.route.snapshot.params.id).subscribe(data => {
      this.amount = data;
      this.originalId = data.id;
      let s = this.amount.created.toString();
      let s2 = s.substr(0, 10);
      this.amount.created = s2;
    })
  }

  save(): void {
    console.log(this.amount);
    this.http.post<any>
    (environment.apiUrl + '/bank/amounts/edit/'+this.originalId, this.amount)
      .subscribe(e => console.log(e),
          error => console.log(error));
    this.router.navigate(['amount']);
  }

  back(): void {
    this.router.navigate(['amount']);
  }

}
