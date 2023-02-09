import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { faTimes } from '@fortawesome/free-solid-svg-icons';
import { Task } from '../Task';

@Component({
  selector: 'app-task-item',
  templateUrl: './task-item.component.html',
  styleUrls: ['./task-item.component.scss']
})
export class TaskItemComponent implements OnInit{
  @Input() task!: Task;
  @Output() onDeleteTask: EventEmitter<Task> = new EventEmitter();
  @Output() onToggleReminder: EventEmitter<Task> = new EventEmitter();
  faTimes = faTimes;

  constructor() {}
  value:number = 0;

  ngOnInit(): void {

    this.value = this.task.value;

  }

  onDelete(task: Task) {
    console.log("Montu mia....Deleted.") 
    this.onDeleteTask.emit(task);
  }

  onToggle(task: Task) {
    task.value = this.value;
    this.onToggleReminder.emit(task);
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
