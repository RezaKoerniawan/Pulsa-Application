package com.reza.pulsa.application.ui.feature.pulsa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.reza.pulsa.application.R
import com.reza.pulsa.application.databinding.ActivityPulsaBinding
import com.reza.pulsa.application.ui.feature.pulsa.adapter.ViewPagerAdapter

class PulsaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPulsaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPulsaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarTitle.toolbarTitle.text = getString(R.string.title_page_top_up)

        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(PulsaFragment(), getString(R.string.title_tab_pulsa))
        adapter.addFragment(PulsaFragment(), getString(R.string.title_tab_paket_data))

        binding.viewPager.adapter = adapter
        binding.tbLayout.setupWithViewPager(binding.viewPager)

    }
}