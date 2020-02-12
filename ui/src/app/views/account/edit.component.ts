import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {ActivatedRoute, Router} from '@angular/router';
import { DatePipe } from '@angular/common';

interface dataRecord {
  id: number;
  active: boolean;
  number: string;
  created: string;
  restriction: [];
  person: any;
  personId: number
}

@Component({
  templateUrl: 'edit.component.html',
  changeDetection: ChangeDetectionStrategy.Default,
  providers: [DatePipe]
})
export class EditComponent implements OnInit {

  account: dataRecord;
  originalId: number;

  constructor(private router: Router, private route: ActivatedRoute, private http: HttpClient, private datePipe: DatePipe) {
  }

  ngOnInit(): void {
    this.http.get<any>(environment.apiUrl + '/bank/account/' + this.route.snapshot.params.id).subscribe(data => {
      this.account = data;
      this.originalId = data.id;
      let s = this.account.created.toString();
      let s2 = s.substr(0, 10);
      this.account.created = s2;
    })
  }

  save(): void {
    console.log(this.account);
    this.http.post<any>
    (environment.apiUrl + '/bank/accounts/edit/'+this.originalId, this.account)
      .subscribe(e => console.log(e),
          error => console.log(error));
    this.router.navigate(['account']);
  }

  back(): void {
    this.router.navigate(['account']);
  }

}
