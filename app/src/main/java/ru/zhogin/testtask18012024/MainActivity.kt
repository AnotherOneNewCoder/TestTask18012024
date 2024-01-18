package ru.zhogin.testtask18012024

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import dagger.hilt.android.AndroidEntryPoint
import ru.zhogin.testtask18012024.data.Resource
import ru.zhogin.testtask18012024.screens.MainScreen
import ru.zhogin.testtask18012024.ui.theme.TestTask18012024Theme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            val list = viewModel.list.collectAsState()
            TestTask18012024Theme {

                list.value?.let {
                    when(it){
                        is Resource.Failure -> Toast.makeText(context, "FAIL", Toast.LENGTH_SHORT).show()
                        Resource.Loading -> Toast.makeText(context, "LOADING", Toast.LENGTH_SHORT).show()
                        is Resource.Success -> {

                            MainScreen(list = it.result)
                        }

                    }
                }


            }
        }
    }
}
