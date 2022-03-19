package com.itacademy.alertdialogapp.dictionaries

data class Location(
    var cityName: String,
    val lat: Double,
    val lon: Double
){

    override fun toString(): String {
        return cities
    }
}
