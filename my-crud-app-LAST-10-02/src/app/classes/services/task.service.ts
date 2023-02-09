import { HttpClient, HttpHandler, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
// import { TASKS } from '../mock-tasks';
import { Task } from '../Task';

const httpOptions = {
  headers : new HttpHeaders({
    'Content-Type':'application/json'
  })
}


@Injectable({
  providedIn: 'root'
})
export class TaskService {



  private uel = 'http://localhost:5000/tasks';
  constructor(private httpService:HttpClient) { }
  
  // getTask(): Observable<Task[]>{
  //   const tasks = of(TASKS);
  //   return tasks;
  // }

  getTask(): Observable<Task[]>{
    const tasks = this.httpService.get<Task[]>(this.uel);
    return tasks;
  }

  deleteTask(task: Task): Observable<Task>{
    const url = `${this.uel}/${task.id}`;
    // this.httpService.delete<Task[]>(this.uel+'/'+task.id);
    return this.httpService.delete<Task>(this.uel+'/'+task.id);
  }


updateReminder(task: Task){
  const url = `${this.uel}/${task.id}`;
  // this.httpService.delete<Task[]>(this.uel+'/'+task.id);
  return this.httpService.put<Task>(this.uel+'/'+task.id, task, httpOptions);

}

addTask(task: Task){
  // this.httpService.delete<Task[]>(this.uel+'/'+task.id);
  return this.httpService.post<Task>(this.uel, task, httpOptions);

}

}