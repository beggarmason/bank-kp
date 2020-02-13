import {ChangeDetectionStrategy, Component, Input, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {ActivatedRoute, Router} from '@angular/router';
import {DatePipe} from '@angular/common';


interface dataRecord {
  id: number;
  name: string;
  year: number;
  created: Date;
}

@Component({
  templateUrl: 'add.component.html',
  changeDetection: ChangeDetectionStrategy.Default,
  providers: [DatePipe]
})
export class TypeAddComponent implements OnInit {

  @Input('ngModel')
  bonus: dataRecord = {
    id: 0,
    name: '',
    year: 0,
    created: new Date()
  };

  name: string = '';
  year: number = 0;
  created: Date = new Date();

  constructor(private router: Router, private route: ActivatedRoute, private http: HttpClient) {}

  ngOnInit(): void {
  }

  save(): void {

    this.bonus.name = this.name;
    this.bonus.created = this.created;
    this.bonus.year = this.year;

    console.log(this.bonus);

    this.http.post<any>
    (environment.apiUrl + '/bank/type/add', this.bonus)
      .subscribe(e => console.log(e),
        error => console.log(error));
    this.router.navigate(['type']);

  }

  back(): void {
    this.router.navigate(['type']);
  }

}
