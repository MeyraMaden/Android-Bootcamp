package com.example.todoapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.Todo
import com.example.todoapp.data.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val repository: TodoRepository
) : ViewModel() {

    private val _query = MutableStateFlow("")
    val todos: StateFlow<List<Todo>> = _query
        .flatMapLatest { repository.search(it) }
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun setQuery(query: String) {
        _query.value = query
    }

    fun add(name: String) {
        viewModelScope.launch { repository.insert(Todo(name = name)) }
    }

    fun update(todo: Todo) {
        viewModelScope.launch { repository.update(todo) }
    }

    fun delete(todo: Todo) {
        viewModelScope.launch { repository.delete(todo) }
    }
}
