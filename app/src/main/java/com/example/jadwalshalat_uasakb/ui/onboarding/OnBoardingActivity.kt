package com.example.jadwalshalat_uasakb.ui.onboarding

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.jadwalshalat_uasakb.R
import com.example.jadwalshalat_uasakb.ui.MainActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class OnBoardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        val vpOnBoarding = findViewById<ViewPager2>(R.id.vpOnBoarding)
        val tlOnBoarding = findViewById<TabLayout>(R.id.tlOnBoarding)

        vpOnBoarding.apply {
            adapter = OnBoardingPagerAdapter(this@OnBoardingActivity)
            TabLayoutMediator(
                tlOnBoarding,
                this
            ) { tab, position ->
            }.attach()
        }

        initSetOnClick()

    }

    private fun initSetOnClick() {
        val vpOnBoarding = findViewById<ViewPager2>(R.id.vpOnBoarding)
        val btnNext = findViewById<Button>(R.id.btnNext)

        btnNext.setOnClickListener {
            if (vpOnBoarding.currentItem == 2) {
                startActivity(Intent(this, MainActivity::class.java))
            } else vpOnBoarding.setCurrentItem(
                vpOnBoarding.currentItem.plus(1),
                true
            )
        }
    }

}