package com.example.mvvmcrashtutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mvvmcrashtutorial.ui.add_edit_todo.AddEditTodoScreen
import com.example.mvvmcrashtutorial.ui.theme.MVVMCrashTutorialTheme
import com.example.mvvmcrashtutorial.ui.todo_list.TodoListScreen
import com.example.mvvmcrashtutorial.util.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMCrashTutorialTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Routes.TODO_LIST
                    ) {
                    composable(Routes.TODO_LIST) {
                        TodoListScreen(
                            onNavigate = {
                                it.route?.let { it1 -> navController.navigate(it1) }
                            }
                        )
                    }
                    composable(
                        Routes.ADD_EDIT_TODO + "?todoId={todoId}",
                            arguments = listOf(
                                navArgument(name = "todoId") {
                                    type = NavType.IntType
                                    defaultValue = -1
                                }
                            )
                        ) {
                        AddEditTodoScreen(
                            onPopBackStack = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}
