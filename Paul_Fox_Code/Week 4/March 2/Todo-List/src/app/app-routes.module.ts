import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { ListDirComponent } from './list-dir/list-dir.component';
import { MyListComponent } from './my-list/my-list.component';

const routes: Routes = [
  {path: "lists", component: ListDirComponent},
  {path: "list/:id", component: MyListComponent }
  {path: "", redirectTo: "/lists", pathMatch: "full"}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutesModule { }
