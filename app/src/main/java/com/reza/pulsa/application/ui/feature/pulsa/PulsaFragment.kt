package com.reza.pulsa.application.ui.feature.pulsa

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.reza.pulsa.application.data.network.model.entity.pulsa.ProductItem
import com.reza.pulsa.application.databinding.FragmentPulsaBinding
import com.reza.pulsa.application.ui.feature.pulsa.adapter.PulsaAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class PulsaFragment : Fragment(), PulsaAdapter.RecyclerViewClickListener {

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
        viewModel.getPulsaList()
        observeData()

        binding.textviewNumberMobile.onRightDrawableClicked {
            it.text.clear()
        }

    }

    private fun observeData() {
        viewModel.pulsaListResult.observe(viewLifecycleOwner) { data ->
            val pulsaAdapter = data?.let { listPulsa -> PulsaAdapter(listPulsa, this@PulsaFragment) }

            binding.rvListPulsa.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = pulsaAdapter
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


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClicked(view: View, pulsaList: ProductItem) {
        Toast.makeText(
            requireContext(),
            "Test ${pulsaList.label} berhasil di klik",
            Toast.LENGTH_SHORT
        ).show()
    }

}