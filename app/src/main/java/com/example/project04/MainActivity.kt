package com.example.project04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.project04.taskscreen.TaskScreen
import com.example.project04.taskscreen.TaskViewModel
import com.example.project04.taskscreen.TaskViewModelFactory
import com.example.project04.ui.theme.Project04Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val taskViewModel: TaskViewModel by viewModels<TaskViewModel> {
            TaskViewModelFactory(
                (this.applicationContext as TodoApplication).database.taskDao()
            )
        }
        setContent {
            Project04Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Greeting("Android")
                    TaskScreen(taskViewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Project04Theme {
        Greeting("Android")
    }
}