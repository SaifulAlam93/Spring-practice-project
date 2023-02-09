import { Injectable } from '@angular/core';
import { Post } from 'src/app/post/post';
import { Task } from '../Task';

const CARD_LIST = 'card-list';

@Injectable({
  providedIn: 'root'
})
export class CardStorageService {


  tasks: Task[] = [];

  constructor() { }

  signOut() {
    window.sessionStorage.clear();
  }

  // public saveToken(token: string) {
  //   window.sessionStorage.removeItem(TOKEN_KEY);
  //   window.sessionStorage.setItem(TOKEN_KEY, token);
  // }

  public deleteCard() {
    return sessionStorage.getItem(CARD_LIST);
  }
  taskListString:string = '';
  public saveCard(task: Task[]) {
    // let taskListString =  sessionStorage.getItem(CARD_LIST);
    // this.tasks = JSON.parse(sessionStorage.getItem(CARD_LIST););
    window.sessionStorage.setItem(CARD_LIST, JSON.stringify(task));
  }

  public getCardlist():string | null {
    // return JSON.parse(sessionStorage.getItem(USER_KEY));
    return sessionStorage.getItem(CARD_LIST);

  }
}
