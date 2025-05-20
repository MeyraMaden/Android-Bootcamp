package com.example.todoapp.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TodoRepository @Inject constructor(private val dao: TodoDao) {

    fun getAll(): Flow<List<Todo>> = dao.getAll()

    fun search(query: String): Flow<List<Todo>> = dao.search("%$query%")

    suspend fun insert(todo: Todo) = dao.insert(todo)

    suspend fun update(todo: Todo) = dao.update(todo)

    suspend fun delete(todo: Todo) = dao.delete(todo)
}
