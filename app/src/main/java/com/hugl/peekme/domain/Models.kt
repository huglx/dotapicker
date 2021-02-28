package com.hugl.peekme.domain

import com.squareup.moshi.Json

class Models {
    data class Hero(@Json(name = "localized_name")
                    val name: String)
}