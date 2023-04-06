package com.reza.pulsa.application.ui.status.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reza.pulsa.application.data.network.model.entity.voucher.VoucherItem
import com.reza.pulsa.application.databinding.ItemListPaymentBinding

class StatusPaymentAdapter(
    private val voucherList: List<VoucherItem>
) : RecyclerView.Adapter<StatusPaymentAdapter.PaymentViewHolder>() {
    inner class PaymentViewHolder(
        val itemListPaymentBinding: ItemListPaymentBinding
    ) : RecyclerView.ViewHolder(itemListPaymentBinding.root)

    override fun getItemCount(): Int = voucherList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        val binding =
            ItemListPaymentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PaymentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {

        holder.itemListPaymentBinding.tvLabelPayment.text = voucherList[position].voucherCode
        holder.itemListPaymentBinding.tvPayment.text = voucherList[position].voucherCode
    }

}