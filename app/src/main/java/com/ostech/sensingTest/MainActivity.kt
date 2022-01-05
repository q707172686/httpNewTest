package com.ostech.sensingTest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.sensing_art.vital.trial.sensinghttp.HttpRequest
import com.sensing_art.vital.trial.sensinghttp.data.HttpMethod
import com.sensing_art.vital.trial.sensinghttp.data.MessageResponse

import com.sensing_art.vital.trial.sensinghttp.data.ResponseData
import com.sensing_art.vital.trial.sensinghttp.request.HttpBody
import com.sensing_art.vital.trial.sensinghttp.request.HttpCallBack
import com.sensing_art.vital.trial.sensinghttp.request.executeAsync
import kotlinx.serialization.json.Json
import java.net.HttpURLConnection


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun doPost(view: View){
        val inputHeards: Map<String, String> = HashMap<String, String>().apply{
            put("x-api-key", "sdthwMrzst6nMRDTsDKmb5yPTBOkEylw7UtzTn01")
            put("Content-Type", "application/json; charset=UTF-8")
        }

        val inputParams: Map<String, String> = HashMap<String, String>().apply{
            put("company_id","TEST0001")
            put("expiration_date","2021-12-31")
        }

        HttpRequest.newBuilder()
            .setUrl("https://29vl2pjj2f.execute-api.ap-northeast-1.amazonaws.com/dev/get/message")
            .setMethod(HttpMethod.POST)
            .setHeader(inputHeards)
            .setBody(HttpBody(params = inputParams))
            .build()
            .executeAsync(object :
                HttpCallBack<ResponseData> {
                override fun onReceivedData(result: ResponseData) {
                    if(result.code== HttpURLConnection.HTTP_OK){
                      var msgResutl : MessageResponse?  = result.messageResponse
                    }
                }
            })
    }
}
