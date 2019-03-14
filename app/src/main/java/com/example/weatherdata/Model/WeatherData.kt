package com.example.weatherdata.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.example.weatherdata.Model.Data



class WeatherData(data: Data,status: Int?,message: String): BaseModel()