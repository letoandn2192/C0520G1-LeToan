import { Component, OnInit } from '@angular/core';
import {FormGroup, FormBuilder, FormControl, Validators} from '@angular/forms';
function comparePassword(formControl: FormGroup) {
  console.log(formControl.value.password);
  return (formControl.value.password === formControl.value.confirmPassword) ? null : {passwordNotMatch: true};
}
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
    this.registerForm = this.fb.group(
      {
        email: ['', Validators.pattern(/^(\\w{3,}@\\w+\\.\\w+)$/)],
        pwGroup: this.fb.group({
          password: ['', Validators.required],
          confirmPassword: ['', Validators.required],
        }, {validator: comparePassword}),
        age: ['', [Validators.required, Validators.min(18)]],
        gender: ['', Validators.required],
        phone: ['', Validators.pattern(/^(090|091|\(84\)\+90|\(84\)\+91)\d{7}$/)]
      }
    );
  }

  onSubmit() {
    console.log(this.registerForm);
    if (this.registerForm.invalid) {
      return;
    }
  }
}
