package com.waigres.model

import java.util.*

open class Date (
    val hour: Int,
    val minute: Int,
    val second: Int
) {
    fun getCalender () : Calendar {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, hour)
        calendar.set(Calendar.MINUTE, minute)
        calendar.set(Calendar.SECOND, second)

        return calendar
    }
}