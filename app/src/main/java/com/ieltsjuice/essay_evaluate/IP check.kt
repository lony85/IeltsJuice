package com.ieltsjuice.essay_evaluate
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.Log
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

fun checkUserCountryCode(context: Context, callback: (String?) -> Unit) {
    val url = "http://ip-api.com/json/"

    val request = Request.Builder()
        .url(url)
        .build()

    val client = OkHttpClient()

    client.newCall(request).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            Log.e("GeoCheck", "Failed to fetch IP info: ${e.message}")
            // Call callback with null on failure
            Handler(Looper.getMainLooper()).post {
                callback(null)
            }
        }

        override fun onResponse(call: Call, response: Response) {
            if (!response.isSuccessful) {
                Log.e("GeoCheck", "Request failed with HTTP ${response.code}")
                Handler(Looper.getMainLooper()).post {
                    callback(null)
                }
                return
            }

            val body = response.body?.string()
            if (body.isNullOrEmpty()) {
                Log.e("GeoCheck", "Empty response body")
                Handler(Looper.getMainLooper()).post {
                    callback(null)
                }
                return
            }

            try {
                val json = JSONObject(body)
                val countryCode = json.optString("countryCode", null)

                // Return result on main thread
                Handler(Looper.getMainLooper()).post {
                    callback(countryCode)  // "IR", "US", etc.
                }

            } catch (e: Exception) {
                Log.e("GeoCheck", "JSON parsing error: ${e.message}")
                Handler(Looper.getMainLooper()).post {
                    callback(null)
                }
            }
        }
    })
}
