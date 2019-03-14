package com.example.weatherdata.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


 open class BaseModel{
    @SerializedName("message")
    @Expose
    private var message: String? = null
    @SerializedName("status")
    @Expose
    private var status: Int? = null
    @SerializedName("data")
    @Expose
    private var data: Any? = null

    fun getMessage(): String? {
        return message
    }

    fun setMessage(message: String) {
        this.message = message
    }

    fun getStatus(): Int? {
        return status
    }

    fun setStatus(status: Int?) {
        this.status = status
    }

    fun getData(): Any? {
        return data
    }

    fun setData(data: Data) {
        this.data = data
    }
 }