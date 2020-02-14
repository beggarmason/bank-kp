import {ChangeDetectionStrategy, ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {MatTableDataSource} from "@angular/material/table";
import { Router } from '@angular/router';
import {FormControl} from "@angular/forms";

interface dataRecord {
  id: number;
  active: boolean;
  balance: number;
  debt: number;
  name: string;
  account: any;
  deposit: any;
  accountId: number
  depositId: number
}

@Component({
  templateUrl: 'amount.component.html',
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
export class AmountComponent implements OnInit {

  amounts: dataRecord[];
  public displayedColumns = ['#', 'id', 'active', 'balance', 'debt', 'name', 'accountid', 'depositid', 'edit', 'remove'];

  filterValues = {
    id: 0,
    balance: 0,
    debt: 0,
    name: 0,
  };

  public dataSource = new MatTableDataSource<dataRecord>();

  ngOnInit(): void {
    this.http.get<any>(environment.apiUrl + '/bank/amounts').subscribe(result => {
      this.amounts = result;
      this.dataSource.data = this.amounts;
      this.idFilter.valueChanges
        .subscribe(
          id => {
            this.filterValues.id = id;
            this.dataSource.filter = JSON.stringify(this.filterValues);
          }
        )
      this.balanceFilter.valueChanges
        .subscribe(
          balance => {
            this.filterValues.balance = balance;
            this.dataSource.filter = JSON.stringify(this.filterValues);
          }
        )
      this.debtFilter.valueChanges
        .subscribe(
          debt => {
            this.filterValues.debt = debt;
            this.dataSource.filter = JSON.stringify(this.filterValues);
          }
        )
      this.nameFilter.valueChanges
        .subscribe(
          name => {
            this.filterValues.name = name;
            this.dataSource.filter = JSON.stringify(this.filterValues);
          }
        )
    });
  }

  constructor(private http: HttpClient, private router: Router) {
    this.dataSource.filterPredicate = this.createFilter();
  }

  createFilter(): (data: any, filter: string) => boolean {
    let filterFunction = function(data, filter): boolean {
      let searchTerms = JSON.parse(filter);
      return data.id.toString().indexOf(searchTerms.id) !== -1
        && data.balance.toString().toLowerCase().indexOf(searchTerms.balance) !== -1
        && data.debt.toString().toLowerCase().indexOf(searchTerms.debt) !== -1
        && data.name.toString().toLowerCase().indexOf(searchTerms.name) !== -1
    }
    return filterFunction;
  }

  idFilter = new FormControl('');
  balanceFilter = new FormControl('');
  debtFilter = new FormControl('');
  nameFilter = new FormControl('');

  public edit(idx: number): void {

    let amounts = this.amounts[idx];
    this.router.navigate(['amountEdit', amounts.id]);
  }

  public remove(id: number, idx: number): void {
    this.http.get<any>(environment.apiUrl + "/bank/amount/remove/" + id)
      .subscribe(result => console.log(result),
        error => {
          console.log(error);
          throw error;
        }, () => {
          this.amounts.splice(idx, 1);
          this.dataSource = new MatTableDataSource(this.amounts);
        });
  }

  public add(): void {
    this.router.navigate(['amount/add']);
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
