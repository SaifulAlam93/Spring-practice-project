import { HttpEventType, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { FileService } from './file.service';

@Component({
  selector: 'app-file-upload',
  templateUrl: './file-upload.component.html',
  styleUrls: ['./file-upload.component.scss']
})
export class FileUploadComponent implements OnInit {


  
  selectedFiles?: FileList;
  progressInfos: any[] = [];
  message: string[] = [];

  fileInfos?: Observable<any>;

  constructor(private uploadService: FileService) { }

  id:number = 50;
  selectFiles(event: any): void {
    this.message = [];
    this.progressInfos = [];
    this.selectedFiles = event.target.files;
  }

  upload(idx: number, file: File): void {
    this.progressInfos[idx] = { value: 0, fileName: file.name };

    if (file) {
      this.uploadService.upload(file,this.id).subscribe({
        next: (event: any) => {
          if (event.type === HttpEventType.UploadProgress) {
            this.progressInfos[idx].value = Math.round(100 * event.loaded / event.total);
          } else if (event instanceof HttpResponse) {
            const msg = file.name + ": Successful!";
            this.message.push(msg);
            this.fileInfos = this.uploadService.getFiles();
          }
        },
        error: (err: any) => {
          this.progressInfos[idx].value = 0;
          let msg = file.name + ": Failed!";

          if (err.error && err.error.message) {
            msg += " " + err.error.message;
          }

          this.message.push(msg);
          this.fileInfos = this.uploadService.getFiles();
        }
      });
    }
  }

  uploadFiles(): void {
    this.message = [];

    if (this.selectedFiles) {
      for (let i = 0; i < this.selectedFiles.length; i++) {
        this.upload(i, this.selectedFiles[i]);
      }
    }
  }

  ngOnInit(): void {
    this.fileInfos = this.uploadService.getFiles();
  }
}
