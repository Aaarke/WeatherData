package com.example.weatherdata

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.weatherdata.Model.Weather
import com.example.weatherdata.Model.WeatherData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.json.JSONObject
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import com.google.gson.GsonBuilder


class MainActivity : AppCompatActivity(), View.OnClickListener {
    var result:String=""
    override fun onClick(v: View?) {
        if(v?.id==btnAdd.id){
            loadAsyncTask()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAdd.setOnClickListener(this)
    }

    private fun loadAsyncTask() {
        runBlocking(Dispatchers.Default) {
            delayFunction()
        }
        var resultJson:JSONObject=JSONObject(result)
        var dataJson:JSONObject= JSONObject()
        dataJson.put("message","Successfull")
        dataJson.put("status",200)
        dataJson.put("data",resultJson)
        val gson = GsonBuilder().create()
        var weather:WeatherData=gson.fromJson(dataJson.getJSONObject("data").toString(),WeatherData::class.java)
        Log.e("Json data",dataJson.toString() )

    }


     fun delayFunction(){
         var data: Int
         var url:URL
        var httpURLConnection: HttpURLConnection? =null
        try {
            url= URL("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22")
            httpURLConnection=url.openConnection()as HttpURLConnection
            var inputStream:InputStream=httpURLConnection.inputStream
            var inputStreamReader:InputStreamReader= InputStreamReader(inputStream)
            data=inputStreamReader.read()
            while (data!=-1){
                var current:Char=data.toChar()
                result+=current
                data=inputStreamReader.read()
            }
        }catch (e:Exception){
            Log.e("Exception",e.toString())
        }

    }
}
