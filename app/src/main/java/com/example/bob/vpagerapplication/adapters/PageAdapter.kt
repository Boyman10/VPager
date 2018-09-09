package com.example.bob.vpagerapplication.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.bob.vpagerapplication.fragments.PageFragment

class PageAdapter : FragmentPagerAdapter {

    private var colors:IntArray

    constructor(fm: FragmentManager?, colors : IntArray) : super(fm)
    {
        this.colors = colors
    }

    override fun getCount(): Int {
        return 5 // number of pages to show
    }

    override fun getItem(position: Int): Fragment {
        return PageFragment.newInstance(position, this.colors[position])
    }
}