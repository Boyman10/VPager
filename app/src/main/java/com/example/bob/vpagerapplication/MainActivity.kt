package com.example.bob.vpagerapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import com.example.bob.vpagerapplication.adapters.PageAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.configureViewPager()
    }

    private fun configureViewPager() {

        val pager: ViewPager =  activity_main_viewpager // findVieById no more needed !!! Thanks to synthetic.main...
        pager.adapter = PageAdapter(supportFragmentManager,resources.getIntArray(R.array.colorPagesViewPager))
    }
}
