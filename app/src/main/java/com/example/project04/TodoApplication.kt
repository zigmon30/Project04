package com.example.project04

import android.app.Application
import com.example.project04.data.TodoDatabase

class TodoApplication : Application() {

    val database: TodoDatabase by lazy {
        TodoDatabase.getInstance(this)
    }

}