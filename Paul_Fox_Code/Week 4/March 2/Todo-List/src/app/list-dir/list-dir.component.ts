import { Component, OnInit } from '@angular/core';
import { TodoList } from '../domain/todo-list';
import { ListsService } from '../services/lists.service';

@Component({
  selector: 'app-list-dir',
  templateUrl: './list-dir.component.html',
  styleUrls: ['./list-dir.component.css']
})
export class ListDirComponent implements OnInit {

  lists: TodoList[] = []

  constructor(private listService: ListsService) { }

  ngOnInit() {
    this.lists = this.listService.getLists();
  }

}
