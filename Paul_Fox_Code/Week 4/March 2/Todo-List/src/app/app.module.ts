import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { MyListComponent } from './my-list/my-list.component';
import { ListItemComponent } from './list-item/list-item.component';
import { ListDirComponent } from './list-dir/list-dir.component';
import { ListsService } from './services/lists.service';
import { AppRoutesModule } from './/app-routes.module';


@NgModule({
  declarations: [
    AppComponent,
    MyListComponent,
    ListItemComponent,
    ListDirComponent
  ],
  imports: [
    BrowserModule,
    AppRoutesModule
  ],
  providers: [ListsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
