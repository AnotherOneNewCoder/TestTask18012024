package ru.zhogin.testtask18012024

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.zhogin.testtask18012024.data.KtorRepos
import ru.zhogin.testtask18012024.data.Resource
import ru.zhogin.testtask18012024.data.models.ListServer
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repos: KtorRepos
): ViewModel(){

    private val _list = MutableStateFlow<Resource<List<ListServer>>?>(null)
    val list: StateFlow<Resource<List<ListServer>>?> = _list

    init {
        viewModelScope.launch {
            _list.value = Resource.Loading
            _list.value = repos.getResult()
        }
    }
}