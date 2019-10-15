package com.gevcorst.stanleygodfreycvapp.model


import com.squareup.moshi.Json

data class Resume(
    @Json(name = "androidPortfolio")
    var androidPortfolio: String = "",
    @Json(name = "education")
    var education: List<Education> = listOf(),
    @Json(name = "email")
    var email: String = "",
    @Json(name = "LinkedIn")
    var linkedIn: String = "",
    @Json(name = "name")
    var name: String = "",
    @Json(name = "phone")
    var phone: String = "",
    @Json(name = "professionalSummary")
    var professionalSummary: List<String> = listOf(),
    @Json(name = "technicalSkill")
    var technicalSkill: TechnicalSkill = TechnicalSkill(),
    @Json(name = "workExperience")
    var workExperience: List<WorkExperience> = listOf()
)