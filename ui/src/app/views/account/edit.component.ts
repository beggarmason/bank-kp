import { Component} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {Observable, pipe} from "rxjs";
import {MatTableDataSource} from "@angular/material/table";
import {element} from "protractor";

interface dataRecord {
  id: number;
  active: boolean;
  created: Date;
  restriction: [];
  person: any;
}

@Component({
  templateUrl: 'edit.component.html',
})
export class EditComponent {

}
