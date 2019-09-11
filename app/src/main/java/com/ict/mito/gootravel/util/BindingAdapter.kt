package com.ict.mito.gootravel.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter

/**
 * Created by mitohato14 on 2019-09-11.
 */
object BindingAdapter {
    @BindingAdapter("android:src")
    @JvmStatic
    fun setImageResource(
        imageView: ImageView,
        resource: Int
    ) {
        imageView.setImageResource(resource)
    }
}