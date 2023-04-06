package com.reza.pulsa.application.ui.voucher.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.reza.pulsa.application.data.network.model.entity.voucher.VoucherItem
import com.reza.pulsa.application.databinding.ItemListVoucherBinding

class VoucherAdapter(
    private val voucherList: List<VoucherItem>,
    private val listener: RecyclerViewClickListener
) : RecyclerView.Adapter<VoucherAdapter.VoucherViewHolder>() {
    inner class VoucherViewHolder(
        val itemLisVoucherBinding: ItemListVoucherBinding
    ) : RecyclerView.ViewHolder(itemLisVoucherBinding.root)

    override fun getItemCount(): Int = voucherList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VoucherViewHolder {
        val binding =
            ItemListVoucherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VoucherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VoucherViewHolder, position: Int) {
        holder.itemLisVoucherBinding.imageView.apply {
            Glide.with(holder.itemLisVoucherBinding.root)
                .load(voucherList[position].imageUrl)
                .into(this)
        }

        holder.itemLisVoucherBinding.tvVoucherCode.text = voucherList[position].voucherCode

        holder.itemLisVoucherBinding.btnUse.setOnClickListener {
            listener.onItemClicked(it, voucherList[position])
        }
    }

    interface RecyclerViewClickListener {
        fun onItemClicked(view: View, voucherList: VoucherItem)
    }

}