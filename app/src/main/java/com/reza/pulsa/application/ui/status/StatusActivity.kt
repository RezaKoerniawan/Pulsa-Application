package com.reza.pulsa.application.ui.status

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import com.reza.pulsa.application.R
import com.reza.pulsa.application.databinding.ActivityStatusBinding
import com.reza.pulsa.application.ui.pulsa.PulsaActivity

class StatusActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStatusBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStatusBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.toolbarTitle.toolbarTitle.text = getString(R.string.title_page_payment_detail)
        binding.toolbarTitle.btnBack.apply {
            setImageDrawable(AppCompatResources.getDrawable(context, R.drawable.ic_close))
            visibility = View.VISIBLE
            setOnClickListener {
                handleBackToStartScreen()
            }
        }

        binding.btnOk.setOnClickListener {
            handleBackToStartScreen()
        }


    }

    private fun handleBackToStartScreen() {
        finish()
        val intent = Intent(this, PulsaActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }


}