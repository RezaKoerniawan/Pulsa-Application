package com.reza.pulsa.application.ui.voucher

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.reza.pulsa.application.R
import com.reza.pulsa.application.data.local.Constants
import com.reza.pulsa.application.data.network.model.entity.voucher.VoucherItem
import com.reza.pulsa.application.databinding.ActivityVoucherBinding
import com.reza.pulsa.application.ui.voucher.adapter.VoucherAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class VoucherActivity : AppCompatActivity(), VoucherAdapter.RecyclerViewClickListener {

    private val viewModel: VoucherViewModel by viewModel()

    private lateinit var binding: ActivityVoucherBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVoucherBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.toolbarTitle.toolbarTitle.text = getString(R.string.title_page_my_voucher)
        binding.toolbarTitle.btnBack.apply {
            visibility = View.VISIBLE
            setOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }
        }

        viewModel.getVoucherList()
        observeData()
    }

    private fun observeData() {
        viewModel.voucherListResult.observe(this) { data ->
            if (data != null) {
                val voucherAdapter =
                    VoucherAdapter(data, this)

                binding.rvListVoucher.apply {
                    layoutManager = LinearLayoutManager(binding.root.context)
                    adapter = voucherAdapter
                }
            }

        }
    }

    override fun onItemClicked(view: View, voucherList: VoucherItem) {
        val intent = Intent()
        intent.putExtra(Constants.EXTRA_VOUCHER_CODE, voucherList.voucherCode)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}