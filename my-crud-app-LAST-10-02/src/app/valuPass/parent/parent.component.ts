import { Component, OnInit} from '@angular/core';
import { Subscription } from 'rxjs';
import { DataService } from 'src/app/data.service';
import { TestDataServiceService } from 'src/app/test-data-service.service';
import { ChildComponent } from '../child/child.component';
// import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.scss']
})
export class ParentComponent implements OnInit{

  // @ViewChild(ChildComponent) child: any;

  disable: boolean= false;

  sharedMessage:string = '';
  subscription!: Subscription;
  abcd: string = 'a';
  def: string = 'b';

checkAccess(){
    if(this.abcd===this.def){
    this.disable = true;
    }else{
    this.disable = false;
    }
}


  gender = '';
  checkedCheckBox = '';
  unCheckedCheckBox = '';
  disableedCheckedCheckBox = '';

  maessage = '';
  post='';
  parentPost: any[] = []; 
  text: string = '';
  constructor(private dataService: TestDataServiceService){}
  
  // constructor(){}
  ngOnInit() {
    this.checkAccess();
    this.subscription = this.dataService.currentMessage.subscribe(message => this.sharedMessage = message);
  }
  // ngAfterViewInit() {
  //   this.maessage = this.child.data;
  // }


  newMessage() {
    this.dataService.changeMessage("Hello from Parents")
  }

  addPost(post: any){
    console.log(post);
    this.parentPost.push(post);

  }

  childEvent(data:any){
    this.text = data;
    alert( this.text)
  }


  ngOnDestroy() {
    this.subscription.unsubscribe();
  }
}
