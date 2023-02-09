import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PostService } from '../post/post.service';
import { PostEmp } from './postEmp';

@Component({
  selector: 'app-practice',
  templateUrl: './practice.component.html',
  styleUrls: ['./practice.component.scss']
})
export class PracticeComponent implements OnInit {
  

  form2!: FormGroup;
  constructor(){}

  ngOnInit(): void {
    this.form2 = new FormGroup({
      title: new FormControl(''),
      body: new FormControl('')
    });
  }


  submit(){
    console.log(this.form2.value);
    // this.postService.create(this.form.value).subscribe((res:any) => {
         console.log('Post created successfully!');
        //  this.router.navigateByUrl('post/index');
    // })
  }
  get f(){
    return this.form2.controls;
  }
  gender:string = '';
  post:string = '';

  postList: PostEmp[] = []
  postObj:PostEmp  = {
    gender: '',
    post: ''
  };
  addPost(){
    this.postObj.gender = this.gender;
    this.postObj.post = this.post;
    this.postList.push(this.postObj)
    this.postObj= {
      gender: '',
      post: ''
    };
    console.log("Array--",this.postList)

  }



  
  // form!: FormGroup;
    
  // /*------------------------------------------
  // --------------------------------------------
  // Created constructor
  // --------------------------------------------
  // --------------------------------------------*/
  // constructor(
  //   public postService: PostService,
  //   private router: Router
  // ) { }
    
  // /**
  //  * Write code on Method
  //  *
  //  * @return response()
  //  */
  // ngOnInit(): void {
  //   this.form = new FormGroup({
  //     title: new FormControl('', [Validators.required]),
  //     body: new FormControl('', Validators.required)
  //   });
  // }
    
  // /**
  //  * Write code on Method
  //  *
  //  * @return response()
  //  */
  // get f(){
  //   return this.form.controls;
  // }
    
  // /**
  //  * Write code on Method
  //  *
  //  * @return response()
  //  */
  // submit(){
  //   console.log(this.form.value);
  //   this.postService.create(this.form.value).subscribe((res:any) => {
  //        console.log('Post created successfully!');
  //        this.router.navigateByUrl('post/index');
  //   })
  // }


}
