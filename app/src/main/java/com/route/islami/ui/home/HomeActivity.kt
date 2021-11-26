package com.route.islami.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.route.islami.R
import com.route.islami.ui.home.fragments.HadethFragment
import com.route.islami.ui.home.fragments.QuranFragment
import com.route.islami.ui.home.fragments.RadioFragment
import com.route.islami.ui.home.fragments.TasbehFragment

class HomeActivity : AppCompatActivity() {
    lateinit var bottomNavigationview: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNavigationview = findViewById(R.id.bottom_navigation)

        bottomNavigationview.setOnItemSelectedListener(
            NavigationBarView.OnItemSelectedListener { item ->
                if (item.itemId == R.id.navigation_quran) {
                    showFragment(QuranFragment())
                } else if (item.itemId == R.id.navigation_hadeth) {
                    showFragment(HadethFragment())
                } else if (item.itemId == R.id.navigation_sebha) {
                    showFragment(TasbehFragment())
                } else if (item.itemId == R.id.navigation_radio) {
                    showFragment(RadioFragment())
                }
                return@OnItemSelectedListener true;
            }
        )
        bottomNavigationview.selectedItemId = R.id.navigation_quran

    }

    fun showFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}