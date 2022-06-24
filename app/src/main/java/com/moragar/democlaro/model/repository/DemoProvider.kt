package com.moragar.democlaro.model.repository

import com.moragar.democlaro.model.data.Demo
import javax.inject.Inject

class DemoProvider @Inject constructor() {

    fun getDemoList() = listOf(
            Demo("Titulo1","Descripción1"),
            Demo("Titulo2","Descripción2"),
            Demo("Titulo3","Descripción3"),
            Demo("Titulo4","Descripción4"),
            Demo("Titulo5","Descripción5"),
            Demo("Titulo6","Descripción6"),
            Demo("Titulo7","Descripción7"),
        )

}