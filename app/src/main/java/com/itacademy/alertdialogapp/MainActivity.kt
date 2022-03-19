package com.itacademy.alertdialogapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.itacademy.alertdialogapp.dictionaries.Constants
import com.itacademy.alertdialogapp.dictionaries.Location
import com.itacademy.alertdialogapp.models.WeatherResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    val cities = arrayListOf<Location>(
        Location("Бишкек", 42.522864, 74.341114),
        Location("Талас", 42.5227700, 72.2427400)
    )


    var location: Location? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)
        val cityName: TextView = findViewById(R.id.cityName)
        val temp: TextView = findViewById(R.id.temp)
        val spinner: Spinner = findViewById(R.id.spinnerCities)
        spinner.adapter = ArrayAdapter<Location>(this, android.R.layout.simple_spinner_item, cities)

        button.setOnClickListener {
            location = spinner.selectedItem as Location
            App.service?.getWeather(location?.lat!!, location?.lon!!, Constants.API_ID)?.enqueue(object : Callback<WeatherResponseModel> {
                    override fun onResponse(
                        call: Call<WeatherResponseModel>,
                        response: Response<WeatherResponseModel>
                    ) {
                        cityName.text = response.body()?.name
                        temp.text = response.body()?.main?.temp.toString()
                    }

                    override fun onFailure(call: Call<WeatherResponseModel>, t: Throwable) {
                        Log.e("Error", t.localizedMessage)
                    }
                })
        }

//
//    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//        location = cities[position]
//    }
//
//    override fun onNothingSelected(parent: AdapterView<*>?) {
//        TODO("Not yet implemented")
    }
    }