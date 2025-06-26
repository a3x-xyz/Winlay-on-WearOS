package com.winlayonwearos.a3x

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import androidx.wear.widget.WearableLinearLayoutManager
import androidx.wear.widget.WearableRecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*

class EventActivity : ComponentActivity() {

    private lateinit var recyclerView: WearableRecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        recyclerView = findViewById(R.id.eventRecyclerView)

        recyclerView.apply {
            isEdgeItemsCenteringEnabled = true
            layoutManager = WearableLinearLayoutManager(this@EventActivity)
        }

        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val events = EventFetcher.fetchEvents()
                val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
                val todaysEvents = events.filter { it.date == today }

                Log.d("EventActivity", "Events found today ($today): ${todaysEvents.size}")

                withContext(Dispatchers.Main) {
                    if (todaysEvents.isNotEmpty()) {
                        recyclerView.adapter = EventAdapter(todaysEvents)
                    } else {
                        recyclerView.adapter = EventAdapter(
                            listOf(
                                EventItem(
                                    date = today,
                                    title = "No events found for today",
                                    description = "",
                                    image = ""
                                )
                            )
                        )
                    }
                }

            } catch (e: Exception) {
                Log.e("EventActivity", "Error: ${e.message}", e)
            }
        }
    }
}
