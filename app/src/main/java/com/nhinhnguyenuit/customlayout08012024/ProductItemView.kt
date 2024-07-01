package com.nhinhnguyenuit.customlayout08012024

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.media.Image
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isGone
import androidx.core.view.isVisible

class ProductItemView : LinearLayout {
    private var title: String = ""
    private var subTitle: String = ""
    private var icon: Drawable? = null
    private var backgroundIcon: Drawable? = null
    private var showTrailing: Boolean = false

    private lateinit var imageIcon: ImageView
    private lateinit var imageTrailing: ImageView
    private lateinit var tvTitle: TextView
    private lateinit var tvSubTitle: TextView
    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initView(context, attrs)
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initView(context, attrs)
    }

    private fun initView(context: Context?, attrs: AttributeSet?) {
        if (context == null || attrs == null) return
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.layout_item_product, this, true)
        setAttrs(context, attrs)
        mapView(view)
    }

    private fun mapView(view: View) {
        imageIcon = view.findViewById(R.id.imageIcon)
        imageTrailing = view.findViewById(R.id.imageTrailingIcon)
        tvTitle = view.findViewById(R.id.textViewTitle)
        tvSubTitle = view.findViewById(R.id.textViewSubTitle)

        tvTitle.setTextOrGone(title)
        tvSubTitle.setTextOrGone(subTitle)
        imageIcon.apply {
            isVisible = icon != null

            icon.takeIf { it != null }?.let {
                setImageDrawable(it)
            }

            backgroundIcon.takeIf { it != null }?.let {
                background = backgroundIcon
            }
        }

        imageTrailing.isGone = !showTrailing
    }

    private fun setAttrs(context: Context, attrs: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ProductItemView)
        title = typedArray.getString(R.styleable.ProductItemView_title) ?: ""
        subTitle = typedArray.getString(R.styleable.ProductItemView_subTitle) ?: ""
        icon = typedArray.getDrawable(R.styleable.ProductItemView_item_icon)
        backgroundIcon = typedArray.getDrawable(R.styleable.ProductItemView_item_background_icon)
        showTrailing = typedArray.getBoolean(R.styleable.ProductItemView_showTrailing, false)
        typedArray.recycle()
    }
}