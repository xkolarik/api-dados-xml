import { Component } from '@angular/core';

@Component({
  selector: 'app-file-upload',
  templateUrl: './file-upload.component.html',
  styleUrls: ['./file-upload.component.css']
})
export class FileUploadComponent {
  isUploading = false;
  selectedFiles: File[] = [];

  onFileSelected(event: any) {
    // Extract selected files and add them to the selectedFiles array
    const newFiles: FileList = event.target.files;
    
    for (let i = 0; i < newFiles.length; i++) {
      this.selectedFiles.push(newFiles[i]);
    }
  }

  uploadFile() {
    this.isUploading = true;

    // Simulate an upload process for each selected file (replace with your actual upload logic)
    for (const file of this.selectedFiles) {
      setTimeout(() => {
        this.isUploading = false;
        console.log(`Uploaded: ${file.name}`);
      }, 3000); // Simulating a 3-second upload process
    }

    // Clear the selected files array after upload
    this.selectedFiles = [];
  }
}
