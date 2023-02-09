import { Component, OnInit } from '@angular/core';
import { TASKS } from '../mock-tasks';
import { TaskService } from '../services/task.service';
import { Task } from '../Task';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.scss']
})
export class TasksComponent implements OnInit{
 tasks: Task[] = [];
 
 constructor(private taskService: TaskService){}
 
  ngOnInit(): void {
    // this.taskService.getTask().subscribe((tasks: Task[]) => {
    // this.tasks = tasks
    // });



  }

  deleteTask(task: Task){
    // console.log("Task was deleted from Parent component..")
    // this.taskService.deleteTask(task).subscribe((tasks: Task) => {
    //   this.tasks = this.tasks.filter(t => t.id !== task.id)});
      this.tasks = this.tasks.filter(t => t.id !== task.id)
  }


  togolReminder(task:Task){
    // task.reminder = !task.reminder;
    console.log(task.reminder);
    this.taskService.updateReminder(task).subscribe();
  }
  addTask(task: Task){

console.log("Task ----", task)

    // this.taskService.addTask(task).subscribe((res: Task) => {
    //   this.tasks.push(res)
    //   });  
      this.tasks.push(task)

    }
}   
