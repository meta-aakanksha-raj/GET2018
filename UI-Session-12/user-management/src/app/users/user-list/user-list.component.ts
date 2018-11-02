import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  constructor(private userService: UserService,private route: Router) { }

  usersList : User[] ;
  ngOnInit() { 
    this.getUsers();
  }

  getUsers(): void {
    this.userService.getUsers()
        .subscribe(users => this.usersList = users);
  }

  passUserToUpdate(user: User) {
    this.route.navigate(['/saveUser',user.id]);
  }
  
  passUserToAdd() {
    this.route.navigate(['/saveUser',0]);
  }

}
