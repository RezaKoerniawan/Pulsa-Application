package com.reza.pulsa.application.ui.feature.pulsa

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.reza.pulsa.application.data.local.Constants
import com.reza.pulsa.application.data.network.model.entity.pulsa.ProductItem
import com.reza.pulsa.application.data.network.model.entity.voucher.VoucherItem
import com.reza.pulsa.application.databinding.FragmentPulsaBinding
import com.reza.pulsa.application.ui.feature.promos.DetailPromosActivity
import com.reza.pulsa.application.ui.feature.pulsa.adapter.PromosAdapter
import com.reza.pulsa.application.ui.feature.pulsa.adapter.PulsaAdapter
import com.reza.pulsa.application.ui.feature.transaction.TransactionActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class PulsaFragment : Fragment(),
    PulsaAdapter.RecyclerViewClickListener,
    PromosAdapter.RecyclerViewClickListener {

    private val viewModel: PulsaViewModel by viewModel()

    private var _binding: FragmentPulsaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPulsaBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewInputNumberMobile()
    }

    private fun setViewInputNumberMobile() {
        binding.textviewNumberMobile.apply {
            onRightDrawableClicked {
                it.text.clear()
                setViewGone()
            }

            doAfterTextChanged {
                if (!text.isNullOrBlank() && text?.length == 4) {
                    viewModel.getPulsaList()
                    viewModel.getVoucherList()
                    observeData()
                } else {
                    setViewGone()
                }
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun EditText.onRightDrawableClicked(onClicked: (view: EditText) -> Unit) {
        this.setOnTouchListener { v, event ->
            var hasConsumed = false
            if (v is EditText) {
                if (event.x >= v.width - v.totalPaddingRight) {
                    if (event.action == MotionEvent.ACTION_UP) {
                        onClicked(this)
                    }
                    hasConsumed = true
                }
            }
            hasConsumed
        }
    }

    private fun observeData() {
        viewModel.pulsaListResult.observe(viewLifecycleOwner) { data ->
            if (data != null) {
                setViewVisible()
            }

            val pulsaAdapter =
                data?.let { listPulsa -> PulsaAdapter(listPulsa, this@PulsaFragment) }

            binding.rvListPulsa.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = pulsaAdapter
            }
        }

        viewModel.voucherListResult.observe(viewLifecycleOwner) { data ->
            val promosAdapter =
                data?.let { listVoucher -> PromosAdapter(listVoucher, this@PulsaFragment) }
            binding.rvListPromos.apply {
                layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
                adapter = promosAdapter
            }

        }
    }

    private fun setViewVisible() {
        binding.line1.visibility = View.VISIBLE
        binding.line2.visibility = View.VISIBLE
        binding.rvListPulsa.visibility = View.VISIBLE
        binding.rvListPromos.visibility = View.VISIBLE
        binding.tvPromos.visibility = View.VISIBLE
    }

    private fun setViewGone() {
        binding.line1.visibility = View.GONE
        binding.line2.visibility = View.GONE
        binding.rvListPulsa.visibility = View.GONE
        binding.rvListPromos.visibility = View.GONE
        binding.tvPromos.visibility = View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClicked(view: View, pulsaList: ProductItem) {
        activity?.let {
            val bundle = Bundle()
            bundle.putString(Constants.EXTRA_NUMBER_MOBILE, binding.textviewNumberMobile.text?.toString())
            bundle.putString(Constants.EXTRA_NOMINAL, pulsaList.nominal)
            val intent = Intent(it, TransactionActivity::class.java)
            intent.putExtras(bundle)
            it.startActivity(intent)
        }
    }

    override fun onItemClicked(view: View, voucherList: VoucherItem) {
        activity?.let {
            val bundle = Bundle()
            bundle.putString(Constants.EXTRA_PROMO_IMAGE, voucherList.imageUrl)
            bundle.putString(Constants.EXTRA_PROMO_CODE, voucherList.voucherCode)
            val intent = Intent(it, DetailPromosActivity::class.java)
            intent.putExtras(bundle)
            it.startActivity(intent)
        }
    }

}