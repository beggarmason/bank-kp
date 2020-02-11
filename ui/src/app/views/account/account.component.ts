import {ChangeDetectionStrategy, ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {Observable, pipe} from "rxjs";
import {MatTableDataSource} from "@angular/material/table";
import {element} from "protractor";
import { Router } from '@angular/router';

interface dataRecord {
  id: number;
  active: boolean;
  created: Date;
  restriction: [];
  person: any;
}

@Component({
  templateUrl: 'account.component.html',
  changeDetection: ChangeDetectionStrategy.Default
})
export class AccountComponent implements OnInit {

  // accounts: Observable<dataRecord[]> = this.http.get<any>(environment.apiUrl + '/bank/accounts');

  accounts: dataRecord[];
  public displayedColumns = ['number', 'id', 'created', 'active', 'person', 'edit', 'remove'];

  public dataSource = new MatTableDataSource<dataRecord>();

  ngOnInit(): void {
    this.http.get<any>(environment.apiUrl + '/bank/accounts').subscribe(result => {
      this.accounts = result;
      this.dataSource.data = this.accounts;
    });
  }

  public doFilter = (value: string) => {
    this.dataSource.filter = value.trim().toLocaleLowerCase();
  }

  constructor(private http: HttpClient, private router: Router) {
  }

  public edit(id: number, idx: number): void {

    this.router.navigateByUrl('accountEdit');
    // this.http.get<any>(environment.apiUrl + "/bank/account/"+id).subscribe(account => {
    //
    // });
  }

  public remove(id: number, idx: number): void {
    this.http.get<any>(environment.apiUrl + "/bank/accounts/remove/" + id)
      .subscribe(result => console.log(result),
        error => {
          console.log(error);
          throw error;
        }, () => {
          this.accounts.splice(idx, 1);
          this.dataSource = new MatTableDataSource(this.accounts);
        });
  }

  public add(): void {
    console.log('add');
  }

  public print(): void {
    console.log('print');
  }
}
