package com.itacademy.alertdialogapp.models

data class WeatherResponseModel(
    val coord: Coordinates,
    val weather: List<Weather>,
    val base: String,
    val main: Main,
    val name: String?
)
data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)

data class Main(
    val temp: Double?
)

data class Coordinates(
    val lon: Double,
    val lat: Double
)
