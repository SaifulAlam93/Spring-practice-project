import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { PostModule } from './post/post.module';
import { ParentComponent } from './valuPass/parent/parent.component';
import { ChildComponent } from './valuPass/child/child.component';
import { Class1Component } from './classes/class1/class1.component';
import { Class2Component } from './classes/class2/class2.component';
import { HeaderComponent } from './classes/header/header.component';
import { ButtonComponent } from './classes/button/button.component';
import { TasksComponent } from './classes/tasks/tasks.component';
import { ClassesComponent } from './classes/classes.component';
import { TaskItemComponent } from './classes/task-item/task-item.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { AddTaskComponent } from './classes/add-task/add-task.component';
import { FileUploadComponent } from './file-upload/file-upload.component';
import { LoginFormComponent } from './login/login-form/login-form.component';
import { RegisterComponent } from './login/register/register.component';
import { HomeComponent } from './login/home/home.component';
import { ProfileComponent } from './login/profile/profile.component';
import { BoardAdminComponent } from './login/board-admin/board-admin.component';
import { BoardModeratorComponent } from './login/board-moderator/board-moderator.component';
import { BoardUserComponent } from './login/board-user/board-user.component';
import { authInterceptorProviders } from './login/AuthInterceptor';
import { NaveBarComponent } from './classes/nave-bar/nave-bar.component';
import { SideBarComponent } from './classes/side-bar/side-bar.component';
import { BodyComponent } from './classes/body/body.component';
import { PracticeComponent } from './practice/practice.component';




@NgModule({
  declarations: [
    AppComponent,
    ParentComponent,
    ChildComponent,
    Class1Component,
    Class2Component,
    HeaderComponent,
    ButtonComponent,
    TasksComponent,
    ClassesComponent,
    TaskItemComponent,
    AddTaskComponent,
    FileUploadComponent,
    LoginFormComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    BoardAdminComponent,
    BoardModeratorComponent,
    BoardUserComponent,
    NaveBarComponent,
    SideBarComponent,
    BodyComponent,
    PracticeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    PostModule,
    FontAwesomeModule,
    ReactiveFormsModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
