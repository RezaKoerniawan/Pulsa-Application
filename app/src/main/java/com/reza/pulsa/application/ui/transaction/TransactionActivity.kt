package com.reza.pulsa.application.ui.transaction

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.reza.pulsa.application.R
import com.reza.pulsa.application.data.local.Constants
import com.reza.pulsa.application.databinding.ActivityTransactionBinding
import com.reza.pulsa.application.ui.voucher.VoucherActivity
import com.reza.pulsa.application.utils.Utils

class TransactionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTransactionBinding

    private val SECOND_ACTIVITY_REQUEST_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.toolbarTitle.toolbarTitle.text = getString(R.string.title_page_confirmation_payment)
        binding.toolbarTitle.btnBack.apply {
            visibility = View.VISIBLE
            setOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }
        }

        if (intent.extras != null) {
            val bundle = intent.extras
            val nominalIDR = bundle?.getString(Constants.EXTRA_NOMINAL)?.toDouble()
                ?.let { Utils().formatRupiah(it) }
            val numberMobile = bundle?.getString(Constants.EXTRA_NUMBER_MOBILE)

            binding.tvNumberMobile.text = numberMobile

            binding.tvLabelOperator.text =
                getString(
                    R.string.text_label_operator,
                    nominalIDR,
                    numberMobile
                )

            binding.tvNominal.text = nominalIDR
        }

        binding.btnDiscount.setOnClickListener {
            navigationToNextScreen()
        }

        binding.btnPayment.setOnClickListener {
            handlePaymentButton()
        }

        binding.btnCloseVoucher.setOnClickListener {
            resetVoucher()
        }
    }

    private fun handlePaymentButton() {
        if (!binding.textviewPin.text.isNullOrEmpty() && binding.textviewPin.text?.length == 6) {
            // next screen
            binding.textInputPin.error = null
        } else {
            binding.textInputPin.error = "Please input your 6 PIN"
        }
    }

    private fun navigationToNextScreen() {
        val intent = Intent(this, VoucherActivity::class.java)
        startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            val voucherCode = data!!.getStringExtra(Constants.EXTRA_VOUCHER_CODE)
            binding.tvLabelVoucherApplied.text = voucherCode
            showViewAfterVoucherApplied()
        }
    }

    private fun resetVoucher() {
        binding.clServiceFee.visibility = View.GONE
        binding.clKredivoDiscount.visibility = View.GONE
        binding.clVoucher.visibility = View.VISIBLE
        binding.clVoucherApplied.visibility = View.GONE
    }

    private fun showViewAfterVoucherApplied() {
        binding.clServiceFee.visibility = View.VISIBLE
        binding.clKredivoDiscount.visibility = View.VISIBLE
        binding.clVoucher.visibility = View.GONE
        binding.clVoucherApplied.visibility = View.VISIBLE
    }


}