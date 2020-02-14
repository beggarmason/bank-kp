import {ChangeDetectionStrategy, ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {MatTableDataSource} from "@angular/material/table";
import { Router } from '@angular/router';
import {FormControl} from "@angular/forms";

interface dataRecord {
  id: number;
  active: boolean;
  currency: string;
  fromDate: Date;
  name: string;
  toDate: Date;
  year: number;
  bonus: any;
  person: any;
  plan: any;
  type: any;
  bonusid: number;
  personid: number;
  planid: number;
  typeid: number;
}

@Component({
  templateUrl: 'deposit.component.html',
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
export class DepositComponent implements OnInit {

  accounts: dataRecord[];
  public displayedColumns = ['#', 'id', 'name', 'currency', 'fromDate','toDate', 'year', 'bonus', 'person', 'plan', 'type', 'edit', 'remove'];

  filterValues = {
    id: 0,
    year: 0,
    name: '',
    currency: ''
  };

  public dataSource = new MatTableDataSource<dataRecord>();

  ngOnInit(): void {
    this.http.get<any>(environment.apiUrl + '/bank/deposits').subscribe(result => {
      this.accounts = result;
      this.dataSource.data = this.accounts;
      this.idFilter.valueChanges
        .subscribe(
          id => {
            this.filterValues.id = id;
            this.dataSource.filter = JSON.stringify(this.filterValues);
          }
        )
      this.yearFilter.valueChanges
        .subscribe(
          year => {
            this.filterValues.year = year;
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
      this.currencyFilter.valueChanges
        .subscribe(
          currency => {
            this.filterValues.currency = currency;
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
        && data.year.toString().toLowerCase().indexOf(searchTerms.year) !== -1
        && data.name.toString().toLowerCase().indexOf(searchTerms.name) !== -1
        && data.currency.toString().toLowerCase().indexOf(searchTerms.currency) !== -1
    }
    return filterFunction;
  }

  idFilter = new FormControl('');
  yearFilter = new FormControl('');
  nameFilter = new FormControl('');
  currencyFilter = new FormControl('');

  public edit(idx: number): void {

    let account = this.accounts[idx];
    this.router.navigate(['depositEdit', account.id]);
  }

  public remove(id: number, idx: number): void {
    this.http.get<any>(environment.apiUrl + "/bank/deposit/remove/" + id)
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
    this.router.navigate(['deposit/add']);
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
