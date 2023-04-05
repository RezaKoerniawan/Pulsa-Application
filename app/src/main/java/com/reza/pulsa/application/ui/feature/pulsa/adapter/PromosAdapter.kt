package com.reza.pulsa.application.ui.feature.pulsa.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.reza.pulsa.application.data.network.model.entity.voucher.VoucherItem
import com.reza.pulsa.application.databinding.ItemListPromosBinding

class PromosAdapter(
    private val voucherList: List<VoucherItem>,
    private val listener: RecyclerViewClickListener
) : RecyclerView.Adapter<PromosAdapter.PromoViewHolder>() {
    inner class PromoViewHolder(
        val itemListPromosBinding: ItemListPromosBinding
    ) : RecyclerView.ViewHolder(itemListPromosBinding.root)

    override fun getItemCount(): Int = voucherList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromoViewHolder {
        val binding =
            ItemListPromosBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PromoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PromoViewHolder, position: Int) {
        holder.itemListPromosBinding.imageView.apply {

            Glide.with(holder.itemListPromosBinding.root)
                .load(voucherList[position].imageUrl)
                .into(this)

            setOnClickListener {
                listener.onItemClicked(it, voucherList[position])
            }
        }
    }

    interface RecyclerViewClickListener {
        fun onItemClicked(view: View, voucherList: VoucherItem)
    }

}