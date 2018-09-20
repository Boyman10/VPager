package com.example.bob.vpagerapplication.adapters

import android.content.res.TypedArray
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.bob.vpagerapplication.fragments.PageFragment
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import java.io.ByteArrayOutputStream


class PageAdapter : FragmentPagerAdapter {

    private var colors:IntArray
    private var emos:TypedArray

    constructor(fm: FragmentManager?, colors : IntArray, emos : TypedArray) : super(fm)
    {
        this.colors = colors
        this.emos = emos
    }

    override fun getCount(): Int {
        return 5 // number of pages to show
    }

    override fun getItem(position: Int): Fragment {

        val drawable = this.emos.getDrawable(position)
        val bitmap = (drawable as BitmapDrawable).bitmap
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos)
        val b = baos.toByteArray()
        return PageFragment.newInstance(position, this.colors[position], b)
    }
}