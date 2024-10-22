import { Component, Inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MSAL_BROADCAST_CONFIG, MsalBroadcastService, MsalGuardConfiguration, MsalService } from '@azure/msal-angular';
import { EventMessage, EventType, InteractionStatus, PopupRequest } from '@azure/msal-browser';
import { Subject } from 'rxjs';
import { filter } from 'rxjs/operators';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  loginDisplay = false;
  // private readonly _destroying$ = new Subject<void>();

  constructor(@Inject(MSAL_BROADCAST_CONFIG)private msalGuardConfig: MsalGuardConfiguration, private authService: MsalService, private msalBroadcastService: MsalBroadcastService, private router: Router ) { }

  ngOnInit(): void {
    this.msalBroadcastService.msalSubject$
      .pipe(
        filter((msg: EventMessage) => msg.eventType === EventType.LOGIN_SUCCESS),
      )
      .subscribe((result: EventMessage) => {
        console.log(result);
      });

    this.msalBroadcastService.inProgress$
      .pipe(
        filter((status: InteractionStatus) => status === InteractionStatus.None)
      )
      .subscribe(() => {
        this.setLoginDisplay();
      })
  }

  setLoginDisplay() {
    this.loginDisplay = this.authService.instance.getAllAccounts().length > 0;
  }
  login() {
    if (this.msalGuardConfig.authRequest){
      this.authService.loginPopup({...this.msalGuardConfig.authRequest} as PopupRequest,)
      .subscribe({
        next: (result) => {
          this.router.navigate(['dashboard'])
        }
      })
    } else {
      this.authService.loginPopup();
    }
  }
  
}