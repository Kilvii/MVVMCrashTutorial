package com.example.mvvmcrashtutorial.ui.todo_list

import com.example.mvvmcrashtutorial.data.Todo

sealed class TodoListEvent {

    data class DeleteTodo(val todo: Todo): TodoListEvent()
    data class OnDoneChange(val todo: Todo, val isDone: Boolean): TodoListEvent()
    object OnUndoDeleteClick: TodoListEvent()
    data class OnTodoClick(val todo: Todo): TodoListEvent()
    object OnAddTodoClick: TodoListEvent()
}
