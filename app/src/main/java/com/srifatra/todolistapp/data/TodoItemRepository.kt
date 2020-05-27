package com.srifatra.todolistapp.data.database

import android.app.Application
import androidx.lifecycle.LiveData
import com.srifatra.todolistapp.data.database.TodoItem
import com.srifatra.todolistapp.data.database.TodoItemDao
import com.srifatra.todolistapp.data.database.TodoItemDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TodoItemRepository(application: Application) {
    private val todoItemDao: TodoItemDao
    private val allTodoItems: LiveData<MutableList<TodoItem>>

    init {
        val database = TodoItemDatabase.getInstance(application.applicationContext)
        todoItemDao = database!!.todoDao()
        allTodoItems = todoItemDao.getAllTodoList()
    }

    fun saveTodoItems(todoItems: List<TodoItem>) = runBlocking {
        this.launch(Dispatchers.IO) {
            todoItemDao.saveTodoItems(todoItems)
        }
    }

    fun saveTodoItem(todoItem: TodoItem) = runBlocking {
        this.launch(Dispatchers.IO) {
            todoItemDao.saveTodoItem(todoItem)
        }
    }

    fun updateTodoItem(todoItem: TodoItem) = runBlocking {
        this.launch(Dispatchers.IO) {
            todoItemDao.updateTodoItem(todoItem)
        }
    }

    fun deleteTodoItem(todoItem: TodoItem) = runBlocking {
        this.launch(Dispatchers.IO) {
            todoItemDao.deleteTodoItem(todoItem)
        }
    }

    fun getAllTodoList(): LiveData<MutableList<TodoItem>> {
        return allTodoItems
    }
}