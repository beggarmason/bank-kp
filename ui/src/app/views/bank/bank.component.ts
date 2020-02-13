import {ChangeDetectionStrategy, ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {MatTableDataSource} from "@angular/material/table";
import { Router } from '@angular/router';

interface dataRecord {
  id: number;
  active: boolean;
  name: string;
  created: Date;
}

@Component({
  templateUrl: 'bank.component.html',
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
export class BankComponent implements OnInit {

  banks: dataRecord[];
  public displayedColumns = ['#', 'id', 'created', 'active', 'name', 'edit', 'remove'];

  public dataSource = new MatTableDataSource<dataRecord>();

  ngOnInit(): void {
    this.http.get<any>(environment.apiUrl + '/bank/banks').subscribe(result => {
      this.banks = result;
      this.dataSource.data = this.banks;
    });
  }

  public doFilter = (value: string) => {
    this.dataSource.filter = value.trim().toLocaleLowerCase();
  }

  constructor(private http: HttpClient, private router: Router) {}

  public edit(idx: number): void {

    let account = this.banks[idx];
    this.router.navigate(['bankEdit', account.id]);
  }

  public remove(id: number, idx: number): void {
    this.http.get<any>(environment.apiUrl + "/bank/bank/remove/" + id)
      .subscribe(result => console.log(result),
        error => {
          console.log(error);
          throw error;
        }, () => {
          this.banks.splice(idx, 1);
          this.dataSource = new MatTableDataSource(this.banks);
        });
  }

  public add(): void {
    this.router.navigate(['bank/add']);
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
