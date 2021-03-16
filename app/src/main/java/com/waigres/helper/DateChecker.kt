package com.waigres.helper

import com.waigres.model.Date
import java.util.*

open class DateChecker (
    private val startDate: Date,
    private val endDate: Date
) {
    fun isIncludedDate () : Boolean {
        val dateNow = Calendar.getInstance()
        return dateNow.timeInMillis >= startDate.getCalender().timeInMillis && dateNow.timeInMillis <= endDate.getCalender().timeInMillis
    }
}