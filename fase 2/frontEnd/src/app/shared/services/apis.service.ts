import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ApisService {

  API_URL: string = ''; //aca va el endpoint

  constructor(private httpClient: HttpClient) { }


}
