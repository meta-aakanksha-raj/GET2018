import { Component, OnInit, Input } from '@angular/core';
import { UserService } from 'src/app/users/user.service';
import { User } from 'src/app/users/user';

import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-add-edit-user',
  templateUrl: './add-edit-user.component.html',
  styleUrls: ['./add-edit-user.component.css']
})
export class AddEditUserComponent implements OnInit {

  idOfUser: number;
  sub;
  @Input()user=new User();
  
  constructor(private userService: UserService, private route: ActivatedRoute,private router: Router) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(queryParams => {
      this.idOfUser = queryParams.id;
    });
    console.log("id passed : "+this.idOfUser);
    if (this.idOfUser > 0) {
      console.log("Edit the User is called.");
      this.getUser();
    }
    else if(this.idOfUser == 0){
      console.log("Save the User is called.");
    }
    else{
      this.close();
    }
  }

  saveTheUser(user): void {
    console.log("Save the User Function has been called.");
    if(user!==null && user!==undefined)
      {
        if (user.id == null && user.name!==undefined && user.contact!==undefined && user.city!==undefined) {
          console.log("User is being saved..");
          this.userService.addUser(user).subscribe();
        }
        else if(user.id !== null && user.name!==null && user.contact!==null && user.city!==null){
          console.log("User is being edited..");
          this.userService.updateUser(user).subscribe();
        }
        else {
          console.log("User can't be Saved with improper fields.");
        }
      }
    else{
      console.log("User object is null or undefined.");
    }
    this.close();
  }

  getUser(): void {
    this.userService.getUser((this.idOfUser))
      .subscribe(user => this.user = user);
  }

  close(){
    this.router.navigate(['./users']);
  }

}
