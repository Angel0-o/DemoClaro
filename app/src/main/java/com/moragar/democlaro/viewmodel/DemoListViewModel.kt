package com.moragar.democlaro.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moragar.democlaro.model.data.Demo
import com.moragar.democlaro.model.repository.DemoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DemoListViewModel @Inject constructor(
    private val repository: DemoRepository
):ViewModel() {
    val demoLiveData = MutableLiveData<List<Demo>>()

    fun getDemoList(){
        viewModelScope.launch {
            demoLiveData.postValue(repository.getDemoList())
        }
    }
}