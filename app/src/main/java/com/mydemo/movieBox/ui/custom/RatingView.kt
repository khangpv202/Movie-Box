package com.mydemo.movieBox.ui.custom

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.mydemo.movieBox.R

class RatingView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val greenColor = ContextCompat.getColor(context, R.color.home_rating_green)
    private val yellowColor = ContextCompat.getColor(context, R.color.home_rating_yellow)
    private val cycleBackGroundPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = yellowColor
        strokeWidth = 8f
        style = Paint.Style.STROKE
        isAntiAlias = true
        isDither = true
    }
    private val cycleFillPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = yellowColor
        strokeWidth = 8f
        style = Paint.Style.STROKE
        isAntiAlias = true
        isDither = true
        strokeCap = Paint.Cap.ROUND
    }
    private val textValuePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.WHITE
        textSize = 40f
        textAlign = Paint.Align.LEFT
    }
    private val textPercentPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.WHITE
        textSize = 24f
        alpha = 120
        textAlign = Paint.Align.LEFT
    }
    private val padding = 6f
    private var switchColorAt = 50
    private val rectF = RectF()
    private var angle = 0f
    private var percent = 0.0
    private val bounds: Rect = Rect()

    fun setRatingValue(rating: Double) {
        percent = 10 * rating
        angle = ((percent * 360) / 100).toFloat()
        invalidate()
    }

    init {
        context.theme.obtainStyledAttributes(attrs, R.styleable.RatingView, 0, 0).apply {
            try {
                switchColorAt = getInt(R.styleable.RatingView_switchColorAt, 50)
            } finally {
                recycle()
            }
        }
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        setUpRect()
        if (percent >= switchColorAt) {
            cycleBackGroundPaint.color = greenColor
            cycleFillPaint.color = greenColor
        } else {
            cycleBackGroundPaint.color = yellowColor
            cycleFillPaint.color = yellowColor
        }
        cycleBackGroundPaint.alpha = 40

        canvas?.drawArc(rectF, 270f, 360f, false, cycleBackGroundPaint)
        canvas?.drawArc(rectF, 270f, angle, false, cycleFillPaint)
        val text = percent.toInt().toString()
        val yPos = (height.toFloat() / 2 - (textValuePaint.descent() + textValuePaint.ascent()) / 2)
        textValuePaint.getTextBounds(text, 0, text.length, bounds)
        val offset = ((width - bounds.width()) / 2).toFloat() - 8
        canvas?.drawText(
            text, 0, text.length,
            offset,
            yPos, textValuePaint
        )
        val percentText = "%"
        canvas?.drawText(
            percentText, 0, percentText.length,
            offset + bounds.width() + 2,
            yPos - height / 6, textPercentPaint
        )
    }

    private fun setUpRect() {
        val min = width.coerceAtMost(height) - padding
        rectF.left = padding
        rectF.top = padding
        rectF.right = min
        rectF.bottom = min
    }
}