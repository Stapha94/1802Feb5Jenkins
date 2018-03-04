import { Injectable } from '@angular/core';
import { Hero } from '../domain/hero';
import { HEROES } from '../domain/mock-heroes';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { MessageService } from './message.service';

@Injectable()
export class HeroService {

  constructor(private messageService: MessageService) { }

  getHeroes(): Observable<Hero[]> {

    this.messageService.add('HeroService: Fetched Heroes');
    return of(HEROES);

  }

}
