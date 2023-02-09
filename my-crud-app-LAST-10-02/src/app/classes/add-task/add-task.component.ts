import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Subscription } from 'rxjs';
import { UiService } from '../services/ui.service';
import { Task } from '../Task';

@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  styleUrls: ['./add-task.component.scss']
})
export class AddTaskComponent implements OnInit{
  ngOnInit(): void {
  }

  @Output() onAddTask: EventEmitter<Task> = new EventEmitter(); 
  text!:string;
  day!: string;
  reminder: boolean = false;
  value:number = 0;

  showAddTask!: boolean;
  subscription!: Subscription;

  constructor(private uiService: UiService){
    this.subscription = this.uiService.onToggle().subscribe((value)=>this.showAddTask = value)
  }
  onSubmit(){
    if(!this.text)
    {alert('Please Add a task! ')
  return;
  }
  const newTask = {
    text: this.text,
    day:this.day,
    reminder: this.reminder, 
    value: this.value 
  }

  this.onAddTask.emit(newTask);
  this.text = '',
  this.day = '',
  this.reminder = false
  this.value=0;
  }


  increaseCount() {
    this.value++;
  }
  
  decreaseCount() {
    if (this.value > 1) {
      this.value--;
    }
  }



}
