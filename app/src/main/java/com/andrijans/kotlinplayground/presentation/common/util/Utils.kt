package com.andrijans.kotlinplayground.presentation.common.util

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.net.Uri
import com.andrijans.kotlinplayground.presentation.common.constant.Constants

/**
 * Created by andrijanstankovic on 31/08/2017.
 */
class Utils {
    companion object {

        fun getPosterUri(posterPath: String): Uri = Uri.parse(Constants.IMAGE_URL_POSTER + posterPath)

        fun getBackdropUri(backdropPath: String): Uri = Uri.parse(Constants.IMAGE_URL_BACKDROP + backdropPath)

        fun textAsBitmap(text: String, textSize: Float, tectColor: Int): Bitmap {
            val paint = Paint(Paint.ANTI_ALIAS_FLAG)
            paint.textSize = textSize
            paint.color = tectColor
            paint.textAlign = Paint.Align.LEFT
            val baseline = -paint.ascent()
            val width = paint.measureText(text) + 0.0F
            val height = baseline + paint.descent() + 0.0F
            val image = Bitmap.createBitmap(width.toInt(), height.toInt(), Bitmap.Config.ARGB_8888)
            val canvas = Canvas(image)
            canvas.drawText(text, 0F, baseline, paint)
            return image
        }
    }
}