import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Subscription } from 'rxjs';
import { DataService } from 'src/app/data.service';
import { TestDataServiceService } from 'src/app/test-data-service.service';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.scss']
})
export class ChildComponent implements OnInit{
 sharedMessage:string = '';
 subscription!: Subscription;
@Input() childPosts: any[] = [];
data: string = 'String data gooooo...'
@Output() passedEvent= new EventEmitter();



constructor(private dataService: TestDataServiceService){}


  ngOnInit() {
    this.subscription = this.dataService.currentMessage.subscribe(message => this.sharedMessage = message);
  }

  passEvent(){
    this.passedEvent.emit(this.data)
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

  newMessage() {
    this.dataService.changeMessage("Hello from Chaild")
  }
}
