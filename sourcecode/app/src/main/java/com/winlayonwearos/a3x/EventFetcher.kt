package com.winlayonwearos.a3x

import okhttp3.OkHttpClient
import okhttp3.Request
import com.google.gson.Gson

object EventFetcher {
    private val client = OkHttpClient()

    fun fetchEvents(): List<EventItem> {
        val request = Request.Builder()
            .url("https://raw.githubusercontent.com/a3x-xyz/Winlay/refs/heads/main/json/events.json")
            .build()

        client.newCall(request).execute().use { response ->
            val json = response.body?.string()
            return Gson().fromJson(json, EventResponse::class.java).events
        }
    }
}
