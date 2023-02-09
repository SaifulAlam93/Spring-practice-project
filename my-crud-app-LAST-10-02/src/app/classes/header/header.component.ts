import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { UiService } from '../services/ui.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent  implements OnInit {

  title: string = 'Tasl Tracker'
  showAddTask: boolean = false;
  subscription!: Subscription;

  classTitle = 'Class One title';

  constructor(private uiService: UiService){
    this.subscription = this.uiService.onToggle().subscribe((value)=>this.showAddTask = value)
  }
  ngOnInit(){ }

  toggleAddTask() {

    this.uiService.toggleAddTask()

    // window.alert('Allah Allah')
  }
}