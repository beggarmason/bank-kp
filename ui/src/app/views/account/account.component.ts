import {ChangeDetectionStrategy, ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {MatTableDataSource} from "@angular/material/table";
import { Router } from '@angular/router';

interface dataRecord {
  id: number;
  active: boolean;
  number: string;
  created: Date;
  restriction: [];
  person: any;
}

@Component({
  templateUrl: 'account.component.html',
  changeDetection: ChangeDetectionStrategy.Default,
  styles: ['@media print\n' +
  '{\n' +
  '  .add-button, .add-button *, .edit-button, .edit-button *,\n' +
  '  .remove-button, .remove-button *, .print-button, .print-button *\n' +
  '  {\n' +
  '    display: none !important;\n' +
  '  }\n' +
  '}\n']
})
export class AccountComponent implements OnInit {

  accounts: dataRecord[];
  public displayedColumns = ['#', 'id', 'created', 'active', 'number', 'person', 'edit', 'remove'];

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

  constructor(private http: HttpClient, private router: Router) {}

  public edit(idx: number): void {

    let account = this.accounts[idx];
    this.router.navigate(['accountEdit', account.id]);
  }

  public remove(id: number, idx: number): void {
    this.http.get<any>(environment.apiUrl + "/bank/account/remove/" + id)
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
    this.router.navigate(['account/add']);
  }

  public print(): void {
    let buttons = document.getElementsByTagName('button');
    for (var i = 0; i < buttons.length; i++) {
      var button = buttons[i];
      button.setAttribute('display','none');
    }
    window.print();
  }
}
