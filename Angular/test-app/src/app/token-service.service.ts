import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TokenServiceService {

  tokenEmitter= new Subject<string>();

  constructor() { }
}
