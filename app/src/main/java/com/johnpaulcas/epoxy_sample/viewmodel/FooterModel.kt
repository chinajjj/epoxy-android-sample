package com.johnpaulcas.epoxy_sample.viewmodel

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.johnpaulcas.epoxy_sample.R
import kotlinx.android.synthetic.main.footer_layout.view.*

/**
 * Created by johnpaulcas on 21/06/2020.
 */
@EpoxyModelClass(layout = R.layout.footer_layout)
abstract class FooterModel: EpoxyModelWithHolder<FooterModel.FooterHolder>() {

    @EpoxyAttribute
    var footerTitle: String? = ""

    override fun bind(holder: FooterHolder) {
        super.bind(holder)
        holder.tvFooterTitle.text = footerTitle
    }

    inner class FooterHolder: EpoxyHolder() {

        lateinit var tvFooterTitle: AppCompatTextView

        override fun bindView(itemView: View) {
            tvFooterTitle = itemView.tvFooterTitle
        }

    }
}