import {ChangeDetectionStrategy, Component, Input, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {ActivatedRoute, Router} from '@angular/router';
import {DatePipe} from '@angular/common';


interface dataRecord {
  id: number;
  active: boolean;
  year: number;
  created: Date;
}

@Component({
  templateUrl: 'add.component.html',
  changeDetection: ChangeDetectionStrategy.Default,
  providers: [DatePipe]
})
export class BonusAddComponent implements OnInit {

  @Input('ngModel')
  bonus: dataRecord = {
    id: 0,
    active: false,
    year: 0,
    created: new Date()
  };

  active: boolean = false;
  year: number = 0;
  created: Date = new Date();

  constructor(private router: Router, private route: ActivatedRoute, private http: HttpClient) {
  }

  ngOnInit(): void {
  }

  save(): void {

    this.bonus.active = this.active;
    this.bonus.created = this.created;
    this.bonus.year = this.year;

    console.log(this.bonus);

    this.http.post<any>
    (environment.apiUrl + '/bank/bonus/add', this.bonus)
      .subscribe(e => console.log(e),
        error => console.log(error));
    this.router.navigate(['bonus']);

  }

  back(): void {
    this.router.navigate(['bonus']);
  }

}
