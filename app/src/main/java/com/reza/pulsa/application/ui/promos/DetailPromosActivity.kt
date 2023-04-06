package com.reza.pulsa.application.ui.promos

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.reza.pulsa.application.R
import com.reza.pulsa.application.data.local.Constants
import com.reza.pulsa.application.databinding.ActivityDetailPromosBinding

class DetailPromosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailPromosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPromosBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.toolbarTitle.toolbarTitle.text = getString(R.string.title_page_merchant_promo)
        binding.toolbarTitle.btnBack.apply {
            visibility = View.VISIBLE
            setOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }
        }

        if (intent.extras != null) {
            val bundle = intent.extras

            binding.imageView.apply {
                Glide.with(this)
                    .load(bundle?.getString(Constants.EXTRA_PROMO_IMAGE))
                    .into(this)
            }
            binding.tvVoucherCode.text = bundle?.getString(Constants.EXTRA_PROMO_CODE)

            binding.btnVoucherCodeCopy.setOnClickListener {
                bundle?.getString(Constants.EXTRA_PROMO_CODE)?.let { setCopyVoucherCode(it) }
            }
        }
    }

    private fun setCopyVoucherCode(voucherCode: String) {
        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("text", voucherCode)
        clipboardManager.setPrimaryClip(clipData)
        Toast.makeText(this, "Voucher code : $voucherCode copied to clipboard ", Toast.LENGTH_LONG).show()
    }
}