package com.example.todoapp.di

import android.content.Context
import androidx.room.Room
import com.example.todoapp.data.TodoDatabase
import com.example.todoapp.data.TodoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): TodoDatabase =
        Room.databaseBuilder(context, TodoDatabase::class.java, "todo_db").build()

    @Provides
    fun provideTodoDao(db: TodoDatabase): TodoDao =
        db.todoDao()
}
