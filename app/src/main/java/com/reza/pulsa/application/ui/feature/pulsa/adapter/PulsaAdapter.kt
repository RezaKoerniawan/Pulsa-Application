package com.reza.pulsa.application.ui.feature.pulsa.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reza.pulsa.application.data.network.model.entity.pulsa.ProductItem
import com.reza.pulsa.application.databinding.ItemListPulsaBinding
import com.reza.pulsa.application.utils.Utils

class PulsaAdapter(
    private val pulsaList: List<ProductItem>,
    private val listener: RecyclerViewClickListener
) : RecyclerView.Adapter<PulsaAdapter.PulsaViewHolder>() {


    inner class PulsaViewHolder(
        val itemListPulsaBinding: ItemListPulsaBinding
    ) : RecyclerView.ViewHolder(itemListPulsaBinding.root)

    override fun getItemCount(): Int = pulsaList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PulsaViewHolder {
        val binding =
            ItemListPulsaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PulsaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PulsaViewHolder, position: Int) {
        holder.itemListPulsaBinding.tvNominal.text = pulsaList[position].nominal

        holder.itemListPulsaBinding.btnTopUp.text = pulsaList[position].nominal?.let {
            Utils().formatRupiah(
                it.toDouble())
        }

        holder.itemListPulsaBinding.btnTopUp.setOnClickListener {
            listener.onItemClicked(it, pulsaList[position])
        }
    }

    interface RecyclerViewClickListener {
        fun onItemClicked(view: View, pulsaList: ProductItem)
    }

}



