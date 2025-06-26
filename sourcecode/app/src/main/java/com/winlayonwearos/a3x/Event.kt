package com.winlayonwearos.a3x

data class EventResponse(
    val events: List<EventItem>
)

data class EventItem(
    val date: String,
    val title: String,
    val description: String,
    val image: String
)
