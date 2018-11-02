import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddEditUserComponent } from './add-edit-user/add-edit-user.component';

const routes: Routes = [
  { 
    path: '',
    canActivate: [],
    children : [
               { path: 'saveUser/:id',  component: AddEditUserComponent },
        ],
  }
   
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
