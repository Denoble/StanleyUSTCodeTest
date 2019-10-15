package com.gevcorst.stanleygodfreycvapp.model


import com.squareup.moshi.Json

data class Education(
    @Json(name = "degreeAwarded")
    var degreeAwarded: String = "",
    @Json(name = "endDate")
    var endDate: String = "",
    @Json(name = "schoolName")
    var schoolName: String = "",
    @Json(name = "Standing")
    var standing: String = "",
    @Json(name = "startDate")
    var startDate: String = ""
)