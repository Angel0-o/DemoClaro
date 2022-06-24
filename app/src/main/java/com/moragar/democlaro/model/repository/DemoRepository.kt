package com.moragar.democlaro.model.repository

import com.moragar.democlaro.model.data.Demo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DemoRepository @Inject constructor(
    private val provider: DemoProvider
) {

    suspend fun getDemoList():List<Demo>{
        return withContext(Dispatchers.IO){
            val data:List<Demo> = provider.getDemoList()
            data
        }
    }
}