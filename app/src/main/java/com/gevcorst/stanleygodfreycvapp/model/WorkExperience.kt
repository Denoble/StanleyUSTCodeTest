package com.gevcorst.stanleygodfreycvapp.model


import com.squareup.moshi.Json

data class WorkExperience(
    @Json(name = "companyName")
    var companyName: String = "",
    @Json(name = "duties")
    var duties: List<String> = listOf(),
    @Json(name = "endDate")
    var endDate: String = "",
    @Json(name = "GitHub")
    var gitHub: String = "",
    @Json(name = "position")
    var position: String = "",
    @Json(name = "startDate")
    var startDate: String = "",
    @Json(name = "technicalEnvironment")
    var technicalEnvironment: String = ""
)