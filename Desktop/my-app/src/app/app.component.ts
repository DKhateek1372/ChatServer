import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import {ReactiveFormsModule} from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  myForm = ControlGroup;
  user = {firstname: '', lastname: '', email: '', phonenumber: 0, message: ''};
/*   public loginForm = new FormGroup({
    FirstName: new FormControl('FirstName', Validators.required),
    LastName: new FormControl('LastName', Validators.required),
    Email: new FormControl('Email', Validators.required),
    PhoneNumber: new FormControl('PhoneNumber', Validators.required),
    Message: new FormControl('Message', Validators.required)
  }); */
  constructor(private formbuilder: FormBuilder) {}
  doLogin(event) {
    this.user = this.myForm.value;
  }
  ngOnInit() {
    // Called after the constructor, initializing input properties, and the first call to ngOnChanges.
    // Add 'implements OnInit' to the class.
     this.myForm = this.formbuilder.group({

     })
  }
}



