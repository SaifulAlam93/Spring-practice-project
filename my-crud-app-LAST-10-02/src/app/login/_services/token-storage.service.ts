import { Injectable } from '@angular/core';
import { User } from '../user';



const TOKEN_KEY = 'auth-token';
const USER_KEY = 'auth-user';


@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {

  constructor() { }

  signOut() {
    window.sessionStorage.clear();
  }

  public saveToken(token: string) {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token);
  }

  public getToken() {
    return sessionStorage.getItem(TOKEN_KEY);
  }

  public saveUser(user: User) {
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
  }

  public getUser():string | null {
    // return JSON.parse(sessionStorage.getItem(USER_KEY));
    return sessionStorage.getItem(USER_KEY);

  }
}
