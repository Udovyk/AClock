package udovyk.com.aclock.common

import java.text.DateFormatSymbols

fun getMonth(month: Int): String {
    return DateFormatSymbols().months[month]
}