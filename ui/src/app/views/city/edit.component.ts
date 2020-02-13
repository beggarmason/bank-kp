import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {ActivatedRoute, Router} from '@angular/router';
import { DatePipe } from '@angular/common';

interface dataRecord {
  id: number;
  name: string;
  year: number;
}

@Component({
  templateUrl: 'edit.component.html',
  changeDetection: ChangeDetectionStrategy.Default,
  providers: [DatePipe]
})
export class CityEditComponent implements OnInit {

  account: dataRecord;
  originalId: number;

  constructor(private router: Router, private route: ActivatedRoute, private http: HttpClient, private datePipe: DatePipe) {
  }

  ngOnInit(): void {
    this.http.get<any>(environment.apiUrl + '/bank/city/' + this.route.snapshot.params.id).subscribe(data => {
      this.account = data;
      this.originalId = data.id;
    })
  }

  save(): void {
    console.log(this.account);
    this.http.post<any>
    (environment.apiUrl + '/bank/city/edit/'+this.originalId, this.account)
      .subscribe(e => console.log(e),
          error => console.log(error));
    this.router.navigate(['city']);
  }

  back(): void {
    this.router.navigate(['city']);
  }

}
