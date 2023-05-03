package com.reza.pulsa.application.ui.status

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.LinearLayoutManager
import com.reza.pulsa.application.R
import com.reza.pulsa.application.data.local.Constants
import com.reza.pulsa.application.databinding.ActivityStatusBinding
import com.reza.pulsa.application.ui.pulsa.PulsaActivity
import com.reza.pulsa.application.ui.status.adapter.StatusPaymentAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class StatusActivity : AppCompatActivity() {

    private val viewModel: StatusViewModel by viewModel()

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

        if (intent.extras != null) {
            val bundle = intent.extras
            binding.tvNumberMobile.text = bundle?.getString(Constants.EXTRA_NUMBER_MOBILE)
        }

        viewModel.getStatusPayment()
        observeData()

        binding.btnOk.setOnClickListener {
            handleBackToStartScreen()
        }
    }

    private fun observeData() {
        viewModel.statusResult.observe(this) { data ->
            if (data != null) {

                binding.tvOrderId.text = data.orderId
                binding.tvPaymentAmount.text = data.amount

                val statusPaymentAdapter =
                    StatusPaymentAdapter(data.itemResponseList ?: emptyList())

                binding.rvListPayment.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = statusPaymentAdapter
                }
            }

        }
    }

    private fun handleBackToStartScreen() {
        val intent = Intent(this, PulsaActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }


}