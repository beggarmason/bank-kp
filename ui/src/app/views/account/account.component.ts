import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {Observable} from "rxjs";
import {MatTableDataSource} from "@angular/material/table";

interface dataRecord {
  id: number;
  active: boolean;
  created: Date;
  restriction: [];
  person: any;
}

@Component({
  templateUrl: 'account.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class AccountComponent implements OnInit {

  accounts: Observable<dataRecord[]> = this.http.get<any>(environment.apiUrl + '/bank/accounts');

  public displayedColumns = ['id', 'created', 'active', 'person', 'edit', 'remove'];

  public dataSource = new MatTableDataSource<dataRecord>();

  ngOnInit(): void {}

  public doFilter = (value: string) => {
    this.dataSource.filter = value.trim().toLocaleLowerCase();
  }

  constructor(private http: HttpClient) {}

  public edit(): void {
    console.log('edit');
  }

  public remove(): void {
    console.log('remove');
  }

  public add(): void {
    console.log('add');
  }

  public print(): void {
    console.log('print');
  }
}
