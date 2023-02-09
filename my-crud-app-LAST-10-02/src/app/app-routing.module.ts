import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BodyComponent } from './classes/body/body.component';
import { Class1Component } from './classes/class1/class1.component';
import { Class2Component } from './classes/class2/class2.component';
import { ClassesComponent } from './classes/classes.component';
import { NaveBarComponent } from './classes/nave-bar/nave-bar.component';
import { FileUploadComponent } from './file-upload/file-upload.component';
import { CreateComponent } from './post/create/create.component';
import { EditComponent } from './post/edit/edit.component';
import { IndexComponent } from './post/index/index.component';
import { ViewComponent } from './post/view/view.component';
import { PracticeComponent } from './practice/practice.component';
import { ParentComponent } from './valuPass/parent/parent.component';

const routes: Routes = [
  // { path: '', redirectTo: 'post/index', pathMatch: 'full'},
  // { path: '', redirectTo: 'valuePass', pathMatch: 'full'},
  // { path: '', redirectTo: 'class', pathMatch: 'full'},
  { path: 'post', redirectTo: 'post/index', pathMatch: 'full'},
  { path: 'post/index', component: IndexComponent },
  { path: 'post/:postId/view', component: ViewComponent },
  // { path: '', component: CreateComponent },
  { path: 'post/create', component: CreateComponent },
  { path: 'post/:postId/edit', component: EditComponent } ,
  { path: 'valuePass', component: ParentComponent } ,
  { path: 'nav', component: NaveBarComponent } ,
  { path: 'body', component: BodyComponent } ,
  { path: '', component: PracticeComponent } ,
  { path: 'class', component: ClassesComponent
  // , children: [
  //   // {      path:'class2', component: Class2Component    }, 
  //   // { path: '', redirectTo: 'class2', pathMatch: 'full'},
  // ] 
 },
 { path: 'files', component: FileUploadComponent } ,

  { path: '**', component: IndexComponent } 


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
