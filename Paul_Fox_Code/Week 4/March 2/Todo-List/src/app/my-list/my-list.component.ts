import { Component, OnInit } from '@angular/core';
import { TaskItem } from '../domain/task-item';
import { ListsService } from '../services/lists.service';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { TodoList } from "../domain/todo-list";

@Component({
  selector: 'app-my-list',
  templateUrl: './my-list.component.html',
  styleUrls: ['./my-list.component.css']
})
export class MyListComponent implements OnInit {

  list: TodoList;

  selectedItems: TaskItem[] = [];

  

  constructor(private listService: ListsService, private route: ActivatedRoute, private location: Location) { }

  ngOnInit() {

    const id = +this.route.snapshot.paramMap.get('id');
    this.list = this.listService.getList(id);

  }

  // selectItem(item){

  //   let find = this.selectedItems.find(i => {

  //     return i === item;

  //   });

  //   if(find){

  //    this.deselectItem(item);

  //   } else {

  //     this.selectedItems.push(item);

  //   }

  //   console.log(this.selectedItems);

  // }

  selectItem(evt: {item: TaskItem, selected: boolean}) {

    console.log(evt);

    if(evt.selected){

      this.selectedItems.push(evt.item);

    }
    else{
      this.deselectItem(evt.item);
    }

  }

  isSelected(item: TaskItem): boolean {

    const r = this.selectedItems.find(i => {
      return i === item;
    });

    return (r) ? true : false;

  }

  private deselectItem(item: TaskItem) {

    let i = this.selectedItems.findIndex(i => {
      return i === item;
    });

    if (i >= 0){

      this.selectedItems.splice(i, 1);

    }

  }

  deleteItems(){

    while(this.selectedItems.length > 0){

      const elem = this.selectedItems.shift();
      const index = this.list.items.findIndex(i => {
        return i.text === elem.text;
      });
      this.list.items.splice(index, 1);

    }

  }

  goBack(){

    this.location.back();

  }

}
