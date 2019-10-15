package com.gevcorst.stanleygodfreycvapp.model


import com.squareup.moshi.Json

data class TechnicalSkill(
    @Json(name = "AndroidTechnologies")
    var androidTechnologies: String = "",
    @Json(name = "Databases")
    var databases: String = "",
    @Json(name = "DevelopmentTools")
    var developmentTools: String = "",
    @Json(name = "iOSTechnologies")
    var iOSTechnologies: String = "",
    @Json(name = "IntegrationTools")
    var integrationTools: String = "",
    @Json(name = "Languages")
    var languages: String = "",
    @Json(name = ".NETTechnologies")
    var nETTechnologies: String = "",
    @Json(name = "Operating Systems")
    var operatingSystems: String = "",
    @Json(name = "TestingTools")
    var testingTools: String = ""
)