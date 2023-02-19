import { Component } from '@angular/core';
import { Subscription } from 'rxjs';
import { StorageService } from './_services/storage.service';
import { AuthService } from './_services/auth.service';
import { EventBusService } from './_shared/event-bus.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private roles: any[] = [{roleName:'', roleDescription:''}];
  isLoggedIn = false;
  showAdminBoard = false;
  showModeratorBoard = false;
  showNormalBoard = false;

  username?: string;

  eventBusSub?: Subscription;

  constructor(
    private storageService: StorageService,
    private authService: AuthService,
    private eventBusService: EventBusService
  ) {}

  ngOnInit(): void {
    this.isLoggedIn = this.storageService.isLoggedIn();

    if (this.isLoggedIn) {
      const user = this.storageService.getUser();
      console.log("USer---",user)
      this.roles = user.user.role;

      // this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showAdminBoard = this.roles.some(item => item.roleName === 'ROLE_ADMIN')
      // console.log('ROLE_ADMIN---',this.roles.some(item => item.roleName === 'ROLE_ADMIN'))

      // this.showModeratorBoard = this.roles.includes('ROLE_MODERATOR');
      this.showModeratorBoard = this.roles.some(item => item.roleName === 'ROLE_MODERATOR')
      // console.log('ROLE_MODERATOR---',this.roles.some(item => item.roleName === 'ROLE_MODERATOR'))
      
      this.showNormalBoard = this.roles.some(item => item.roleName === 'User');

      this.username = user.user.username;
    }

    this.eventBusSub = this.eventBusService.on('logout', () => {
      this.logout();
    });
  }

  logout(): void {
    // this.authService.logout().subscribe({
    //   next: res => {
    //     console.log(res);
    //     this.storageService.clean();

    //     window.location.reload();
    //   },
    //   error: err => {
    //     console.log(err);
    //   }
    // });

    this.storageService.clean();

    window.location.reload();
  }
}
