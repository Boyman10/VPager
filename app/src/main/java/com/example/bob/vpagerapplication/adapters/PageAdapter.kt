package com.example.bob.vpagerapplication.adapters

import android.content.res.TypedArray
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.bob.vpagerapplication.fragments.PageFragment
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.VectorDrawable
import java.io.ByteArrayOutputStream
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth
import android.util.Log


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

    override fun getItem(position: Int): Fragment? {

        val drawable = this.emos.getDrawable(position)

        Log.d("EMO", "My emo at position : $position " + drawable.toString())

        try {
            val bitmap: Bitmap

            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888)


            //val vectormap = (drawable as BitmapDrawable).bitmap
            val baos = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos)
            val b = baos.toByteArray()

            //return PageFragment.newInstance(position, this.colors[position], b)
            return PageFragment.newInstance(position, this.colors[position], this.emos)

        } catch (e: OutOfMemoryError) {
            // Handle the error
            return null
        }

    }
}