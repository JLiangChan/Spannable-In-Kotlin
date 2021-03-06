package me.gujun.android.span.style

import android.graphics.Paint.FontMetricsInt
import android.text.Spanned
import android.text.style.LineHeightSpan

class VerticalPaddingSpan(private val paddingTop: Int,
    private val paddingBottom: Int) : LineHeightSpan {

  override fun chooseHeight(text: CharSequence, start: Int, end: Int, spanstartv: Int, v: Int,
      fm: FontMetricsInt) {
    text as Spanned
    val spanStart = text.getSpanStart(this)
    val spanEnd = text.getSpanEnd(this)

//    Log.d("DEBUG", "text: \n$text")
//    Log.d("DEBUG", "spanStart: $spanStart")
//    Log.d("DEBUG", "spanEnd: $spanEnd")
//    Log.d("DEBUG", "start: $start")
//    Log.d("DEBUG", "end: $end") // end may include the \n character
//    Log.d("DEBUG", "spanstartv: $spanstartv")
//    Log.d("DEBUG", "v: $v")
//    Log.d("DEBUG", "-----------------------")

    if (spanStart == start) {
      fm.top -= paddingTop
      fm.ascent -= paddingTop
    }
    if (spanEnd == end || spanEnd == end - 1) {
      fm.bottom += paddingBottom
      fm.descent += paddingBottom
    }
  }
}