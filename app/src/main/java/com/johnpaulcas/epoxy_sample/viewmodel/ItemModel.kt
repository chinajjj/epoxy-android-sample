package com.johnpaulcas.epoxy_sample.viewmodel

import android.view.View
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import com.airbnb.epoxy.*
import com.johnpaulcas.epoxy_sample.R
import kotlinx.android.synthetic.main.body_layout.view.*

/**
 * Created by johnpaulcas on 21/06/2020.
 */
@EpoxyModelClass(layout = R.layout.body_layout)
abstract class ItemModel: EpoxyModelWithHolder<ItemModel.ItemHolder>() {

    private var button: Button? = null

    @EpoxyAttribute
    var contentTitle: String? = ""


    @EpoxyAttribute
    var clickButtonListener: View.OnClickListener? = null

    override fun bind(holder: ItemHolder) {
        super.bind(holder)
        holder.tvContentTitle.text = contentTitle

        clickButtonListener?.let {
            holder.btnClick.setOnClickListener(it)
        }

    }

    inner class ItemHolder: EpoxyHolder() {

        lateinit var tvContentTitle: AppCompatTextView
        lateinit var btnClick: AppCompatButton

        override fun bindView(itemView: View) {
            tvContentTitle = itemView.tvContentTitle
            btnClick = itemView.btnClick
        }

    }
}