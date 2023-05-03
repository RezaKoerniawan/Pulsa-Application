package com.reza.pulsa.application.ui.status.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reza.pulsa.application.data.network.model.entity.status.ItemPayment
import com.reza.pulsa.application.databinding.ItemListPaymentBinding
import com.reza.pulsa.application.utils.Utils

class StatusPaymentAdapter(
    private val paymentItemList: List<ItemPayment?>
) : RecyclerView.Adapter<StatusPaymentAdapter.PaymentViewHolder>() {
    inner class PaymentViewHolder(
        val itemListPaymentBinding: ItemListPaymentBinding
    ) : RecyclerView.ViewHolder(itemListPaymentBinding.root)

    override fun getItemCount(): Int = paymentItemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        val binding =
            ItemListPaymentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PaymentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {

        val totalAmountText = paymentItemList.get(position)?.totalAmount?.toDouble()
            ?.let { Utils().formatRupiah(it) }

        holder.itemListPaymentBinding.tvLabelPayment.text = paymentItemList[position]?.name
        holder.itemListPaymentBinding.tvPayment.text = totalAmountText
    }

}